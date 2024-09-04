package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.entity.SofaBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.blocks.properties.SofaType;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.common.utils.WoolHelper;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class SofaBlock extends SeatBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock, EntityBlock {

    // Block Properties
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<SofaType> SHAPE = ModBlockStateProperties.SOFA_TYPE;

    // VoxelShapes
    public static final VoxelShape SEAT_BASE = Block.box(0, 2, 0, 16, 6, 16);
    public static final VoxelShape SEAT_BACK_SINGLE = Stream.of(Block.box(0, 2, 13, 16, 10, 16), Block.box(0, 10, 13.5, 16, 12, 16.5), Block.box(0, 12, 14.25, 16, 14, 17.25), Block.box(0, 14, 15, 16, 16, 18)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SEAT_BACK_MIDDLE = Stream.of(Block.box(0, 2, 13, 16, 10, 16), Block.box(0, 10, 13.5, 16, 12, 16.5), Block.box(0, 12, 14.25, 16, 14, 17.25), Block.box(0, 14, 15, 16, 16, 18)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SEAT_BACK_LEFT = Stream.of(Block.box(0, 2, 13, 16, 10, 16), Block.box(0, 10, 13.5, 16, 12, 16.5), Block.box(0, 12, 14.25, 16, 14, 17.25), Block.box(0, 14, 15, 16, 16, 18)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SEAT_BACK_RIGHT = Stream.of(Block.box(0, 2, 13, 16, 10, 16), Block.box(0, 10, 13.5, 16, 12, 16.5), Block.box(0, 12, 14.25, 16, 14, 17.25), Block.box(0, 14, 15, 16, 16, 18)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape LEG_BL = Block.box(14.0D, 0.0D, 14.0D, 16.0D, 2.0D, 16.0D);
    public static final VoxelShape LEG_BR = Block.box(0.0D, 0.0D, 14.0D, 2.0D, 2.0D, 16.0D);
    public static final VoxelShape LEG_FR = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 2.0D, 2.0D);
    public static final VoxelShape LEG_FL = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 2.0D, 2.0D);

    public static final VoxelShape ARM_L = Block.box(13, 6, 0, 16, 10, 16);
    public static final VoxelShape ARM_R = Block.box(0, 6, 0, 3, 10, 16);

    public static final VoxelShape SINGLE = Shapes.or(SEAT_BASE, SEAT_BACK_SINGLE, ARM_L, ARM_R, LEG_BL, LEG_BR, LEG_FL, LEG_FR);
    public static final VoxelShape SINGLE_EAST = ShapeUtil.rotateShape(SINGLE, Direction.EAST);
    public static final VoxelShape SINGLE_SOUTH = ShapeUtil.rotateShape(SINGLE, Direction.SOUTH);
    public static final VoxelShape SINGLE_WEST = ShapeUtil.rotateShape(SINGLE, Direction.WEST);

    public static final VoxelShape MIDDLE = Shapes.or(SEAT_BASE, SEAT_BACK_MIDDLE);
    public static final VoxelShape MIDDLE_EAST = ShapeUtil.rotateShape(MIDDLE, Direction.EAST);
    public static final VoxelShape MIDDLE_SOUTH = ShapeUtil.rotateShape(MIDDLE, Direction.SOUTH);
    public static final VoxelShape MIDDLE_WEST = ShapeUtil.rotateShape(MIDDLE, Direction.WEST);

    public static final VoxelShape OUTER = Shapes.or(SEAT_BASE, LEG_FR,Stream.of(Block.box(12.45, 6.5, 15.5, 16.2, 10, 16), Block.box(12.95, 10, 15.5, 16.7, 12, 16), Block.box(13.7, 12, 15.5, 17.45, 14, 16), Block.box(14.45, 14, 15.5, 18.2, 16, 16), Block.box(15.5, 6.5, 12.45, 16, 10, 16.2), Block.box(15.5, 10, 12.95, 16, 12, 16.7), Block.box(15.5, 12, 13.7, 16, 14, 17.45), Block.box(15.5, 14, 14.45, 16, 16, 18.2)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
    public static final VoxelShape OUTER_EAST = ShapeUtil.rotateShape(OUTER, Direction.EAST);
    public static final VoxelShape OUTER_SOUTH = ShapeUtil.rotateShape(OUTER, Direction.SOUTH);
    public static final VoxelShape OUTER_WEST = ShapeUtil.rotateShape(OUTER, Direction.WEST);

    public static final VoxelShape INNER = Shapes.or(SEAT_BASE, SEAT_BACK_MIDDLE, LEG_BL, LEG_BR, LEG_FL, Stream.of(Block.box(13, 2, 0, 16, 10, 16), Block.box(13.5, 10, 0, 16.5, 12, 16), Block.box(14.25, 12, 0, 17.25, 14, 16), Block.box(15, 14, 0, 18, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get());
    public static final VoxelShape INNER_EAST = ShapeUtil.rotateShape(INNER, Direction.EAST);
    public static final VoxelShape INNER_SOUTH = ShapeUtil.rotateShape(INNER, Direction.SOUTH);
    public static final VoxelShape INNER_WEST = ShapeUtil.rotateShape(INNER, Direction.WEST);

    public static final VoxelShape RIGHT = Shapes.or(SEAT_BASE, SEAT_BACK_RIGHT, ARM_R, LEG_BR, LEG_FR, LEG_BL);
    public static final VoxelShape RIGHT_EAST = ShapeUtil.rotateShape(RIGHT, Direction.EAST);
    public static final VoxelShape RIGHT_SOUTH = ShapeUtil.rotateShape(RIGHT, Direction.SOUTH);
    public static final VoxelShape RIGHT_WEST = ShapeUtil.rotateShape(RIGHT, Direction.WEST);

    public static final VoxelShape LEFT = Shapes.or(SEAT_BASE, SEAT_BACK_LEFT, ARM_L, LEG_BL, LEG_FL, LEG_BR);
    public static final VoxelShape LEFT_EAST = ShapeUtil.rotateShape(LEFT, Direction.EAST);
    public static final VoxelShape LEFT_SOUTH = ShapeUtil.rotateShape(LEFT, Direction.SOUTH);
    public static final VoxelShape LEFT_WEST = ShapeUtil.rotateShape(LEFT, Direction.WEST);


    public SofaBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    public float seatHeight(BlockState state) {
        return 0.20F;
    }

    @Override
    public BlockPos primaryDismountLocation(Level level, BlockState state, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockState stateRelative = level.getBlockState(pos.relative(facing));

        if (stateRelative.getBlock() instanceof SofaBlock) {
            Direction facingRelative = stateRelative.getValue(FACING);
            if (facing != facingRelative) {
                return pos.relative(facing).relative(facingRelative);
            }
        }
        return pos.relative(facing);
    }

    @Override
    public float setRiderRotation(BlockState state, Entity entity) {
        float corner = switch (state.getValue(SHAPE)) {
            case INNER_LEFT, OUTER_LEFT -> -45.0F;
            case INNER_RIGHT, OUTER_RIGHT -> 45.0F;
            default -> 0.0F;
        };
        return state.getValue(FACING).toYRot() + corner;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState blockState = this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return blockState.setValue(SHAPE, getConnection(blockState, context.getLevel(), blockPos));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        BlockEntity blockEntity = level.getBlockEntity(currentPos);
        if (blockEntity instanceof ILockable lockable && lockable.isLocked()) {
            return state; // Return the current state if the block is locked
        }

        return direction.getAxis().isHorizontal() ? state.setValue(SHAPE, getConnection(state, (Level)level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        SofaType shape = state.getValue(SHAPE);
        return switch (shape) {
            case SINGLE -> switch (facing) {
                case EAST -> SINGLE_EAST;
                case SOUTH -> SINGLE_SOUTH;
                case WEST -> SINGLE_WEST;
                default -> SINGLE;
            };
            case MIDDLE -> switch (facing) {
                case EAST -> MIDDLE_EAST;
                case SOUTH -> MIDDLE_SOUTH;
                case WEST -> MIDDLE_WEST;
                default -> MIDDLE;
            };
            case OUTER_LEFT -> switch (facing) {
                case EAST -> OUTER_EAST;
                case SOUTH -> OUTER_SOUTH;
                case WEST -> OUTER_WEST;
                default -> OUTER;
            };
            case OUTER_RIGHT -> switch (facing) {
                case EAST -> OUTER_SOUTH;
                case SOUTH -> OUTER_WEST;
                case WEST -> OUTER;
                default -> OUTER_EAST;
            };
            case LEFT -> switch (facing) {
                case EAST -> LEFT_EAST;
                case SOUTH -> LEFT_SOUTH;
                case WEST -> LEFT_WEST;
                default -> LEFT;
            };
            case RIGHT -> switch (facing) {
                case EAST -> RIGHT_EAST;
                case SOUTH -> RIGHT_SOUTH;
                case WEST -> RIGHT_WEST;
                default -> RIGHT;
            };
            case INNER_RIGHT -> switch (facing) {
                case EAST -> INNER_SOUTH;
                case SOUTH -> INNER_WEST;
                case WEST -> INNER;
                default -> INNER_EAST;
            };
            case INNER_LEFT -> switch (facing) {
                case EAST -> INNER_EAST;
                case SOUTH -> INNER_SOUTH;
                case WEST -> INNER_WEST;
                default -> INNER;
            };
        };
    }

    public static SofaType getConnection(BlockState state, Level level, BlockPos pos) {
        Direction facing = state.getValue(FACING);

        Direction dir1;
        BlockState state1 = level.getBlockState(pos.relative(facing));
        if (state1.getBlock() instanceof SofaBlock && (dir1 = state1.getValue(FACING)).getAxis() != state.getValue(FACING).getAxis() && isDifferentOrientation(state, level, pos, dir1.getOpposite())) {
            if (dir1 == facing.getCounterClockWise()) {
                return SofaType.INNER_LEFT;
            }
            return SofaType.INNER_RIGHT;
        }

        Direction dir2;
        BlockState state2 = level.getBlockState(pos.relative(facing.getOpposite()));
        if (state2.getBlock() instanceof SofaBlock && (dir2 = state2.getValue(FACING)).getAxis() != state.getValue(FACING).getAxis() && isDifferentOrientation(state, level, pos, dir2)) {
            if (dir2 == facing.getCounterClockWise()) {
                return SofaType.OUTER_LEFT;
            }
            return SofaType.OUTER_RIGHT;
        }

        boolean left = canConnect(level, pos, state.getValue(FACING).getCounterClockWise());
        boolean right = canConnect(level, pos, state.getValue(FACING).getClockWise());
        if (left && right) {
            return SofaType.MIDDLE;
        }
        else if (left) {
            return SofaType.LEFT;
        }
        else if (right) {
            return SofaType.RIGHT;
        }
        return SofaType.SINGLE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (item instanceof HammerItem || item instanceof WrenchItem) {
            return InteractionResult.FAIL;
        }

        if (level.getBlockEntity(pos) instanceof SofaBlockEntity entity) {
            DyeColor woolDye = WoolHelper.getDyeColor(stack.getItem());
            if (woolDye != null && !entity.hasColor()) {
                entity.setColor(woolDye);
                entity.setChanged();
                if (!(player.isCreative())) {
                    stack.shrink(1);
                }
                level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
                return InteractionResult.SUCCESS;
            }
            DyeColor dye = stack.getItem() instanceof DyeItem dyeItem ? dyeItem.getDyeColor() : null;
            if (dye != null && entity.hasColor()) {
                entity.setColor(dye);
                entity.setChanged();
                if (!(player.isCreative())) {
                    stack.shrink(1);
                }
                level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
                return InteractionResult.SUCCESS;
            }
            if (stack.is(ModItems.SHEARS.get()) && entity.hasColor()) {
                dropCushion(level, pos);
                entity.setColor(null);
                entity.setChanged();
                level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new SofaBlockEntity(pos, state);
    }

    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean moving) {
        if (!state.is(newState.getBlock())) {
            dropCushion(level, pos);
        }
        super.onRemove(state, level, pos, newState, moving);
    }

    public static boolean canConnect(Level level, BlockPos pos, Direction direction) {
        BlockState state = level.getBlockState(pos.relative(direction));
        return state.getBlock() instanceof SofaBlock;
    }

    public static boolean isDifferentOrientation(BlockState state, Level level, BlockPos pos, Direction dir) {
        BlockState blockState = level.getBlockState(pos.relative(dir));
        return !(blockState.getBlock() instanceof SofaBlock) || blockState.getValue(FACING) != state.getValue(FACING);
    }



    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.dyeable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.connectable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.lockable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.hammerable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public void dropCushion(Level level, BlockPos pos) {
        if (level.getBlockEntity(pos) instanceof SofaBlockEntity entity) {
            if (entity.hasColor()) {
                Block block = WoolHelper.getBlock(entity.getColor());
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(block != null ? block : Blocks.WHITE_WOOL));
            }
        }
    }

    public List<Property<?>> getHammerableProperties() {
        return List.of(SHAPE);
    }

    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }

    @Override
    public BlockState updateAfterCycle(BlockState state, LevelAccessor level, BlockPos pos) {
        return WrenchItem.WrenchableBlock.super.updateAfterCycle(state, level, pos);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (level.getBlockEntity(pos) instanceof LockableBlockEntity lockable && !lockable.isLocked()) {
            super.neighborChanged(state, level, pos, block, fromPos, isMoving);
        }
    }
}