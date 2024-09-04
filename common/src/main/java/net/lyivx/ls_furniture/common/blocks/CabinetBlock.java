package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.CabinetType;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CabinetBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<CabinetType> SHAPE = ModBlockStateProperties.CABINET_TYPE;

    public static final VoxelShape TOP = Block.box(0, 0, 9, 16, 2, 16);
    public static final VoxelShape TOP_INNER = Shapes.join(Block.box(0, 0, 9, 16, 2, 16), Block.box(9, 0, 0, 16, 2, 9), BooleanOp.OR);
    public static final VoxelShape TOP_OUTER = Block.box(9, 0, 9, 16, 2, 16);
    public static final VoxelShape BACK = Block.box(0, -2, 15, 16, 0, 16);
    public static final VoxelShape BACK_INNER = Shapes.join(Block.box(0, -2, 15, 16, 0, 16), Block.box(15, -2, 0, 16, 0, 15), BooleanOp.OR);
    public static final VoxelShape BACK_OUTER = Block.box(15, -2, 15, 16, 0, 16);
    public static final VoxelShape BASE = Block.box(0, 2, 9, 16, 16, 16);
    public static final VoxelShape BASE_INNER = Shapes.join(Block.box(0, 2, 9, 16, 16, 16), Block.box(9, 2, 0, 16, 16, 9), BooleanOp.OR);
    public static final VoxelShape BASE_OUTER = Block.box(9, 2, 9, 16, 16, 16);

    public static final VoxelShape SINGLE = Shapes.or(TOP, BACK, BASE);
    public static final VoxelShape SINGLE_EAST = ShapeUtil.rotateShape(SINGLE, Direction.EAST);
    public static final VoxelShape SINGLE_SOUTH = ShapeUtil.rotateShape(SINGLE, Direction.SOUTH);
    public static final VoxelShape SINGLE_WEST = ShapeUtil.rotateShape(SINGLE, Direction.WEST);

    public static final VoxelShape MIDDLE = Shapes.or(TOP, BACK, BASE);
    public static final VoxelShape MIDDLE_EAST = ShapeUtil.rotateShape(MIDDLE, Direction.EAST);
    public static final VoxelShape MIDDLE_SOUTH = ShapeUtil.rotateShape(MIDDLE, Direction.SOUTH);
    public static final VoxelShape MIDDLE_WEST = ShapeUtil.rotateShape(MIDDLE, Direction.WEST);

    public static final VoxelShape OUTER = Shapes.or(TOP_OUTER, BACK_OUTER, BASE_OUTER);
    public static final VoxelShape OUTER_EAST = ShapeUtil.rotateShape(OUTER, Direction.EAST);
    public static final VoxelShape OUTER_SOUTH = ShapeUtil.rotateShape(OUTER, Direction.SOUTH);
    public static final VoxelShape OUTER_WEST = ShapeUtil.rotateShape(OUTER, Direction.WEST);

    public static final VoxelShape INNER = Shapes.or(TOP_INNER, BACK_INNER, BASE_INNER);
    public static final VoxelShape INNER_EAST = ShapeUtil.rotateShape(INNER, Direction.EAST);
    public static final VoxelShape INNER_SOUTH = ShapeUtil.rotateShape(INNER, Direction.SOUTH);
    public static final VoxelShape INNER_WEST = ShapeUtil.rotateShape(INNER, Direction.WEST);

    public static final VoxelShape RIGHT = Shapes.or(TOP, BACK, BASE);
    public static final VoxelShape RIGHT_EAST = ShapeUtil.rotateShape(RIGHT, Direction.EAST);
    public static final VoxelShape RIGHT_SOUTH = ShapeUtil.rotateShape(RIGHT, Direction.SOUTH);
    public static final VoxelShape RIGHT_WEST = ShapeUtil.rotateShape(RIGHT, Direction.WEST);

    public static final VoxelShape LEFT = Shapes.or(TOP, BACK, BASE);
    public static final VoxelShape LEFT_EAST = ShapeUtil.rotateShape(LEFT, Direction.EAST);
    public static final VoxelShape LEFT_SOUTH = ShapeUtil.rotateShape(LEFT, Direction.SOUTH);
    public static final VoxelShape LEFT_WEST = ShapeUtil.rotateShape(LEFT, Direction.WEST);


    public CabinetBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
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
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        BlockEntity blockEntity = level.getBlockEntity(currentPos);
        if (blockEntity instanceof ILockable lockable && lockable.isLocked()) {
            return state; // Return the current state if the block is locked
        }

        return direction.getAxis().isHorizontal() ? state.setValue(SHAPE, getConnection(state, (Level)level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        CabinetType shape = state.getValue(SHAPE);
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

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE, WATERLOGGED);
    }

    public static CabinetType getConnection(BlockState state, Level level, BlockPos pos) {
        Direction facing = state.getValue(FACING);

        Direction dir1;
        BlockState state1 = level.getBlockState(pos.relative(facing));
        if (state1.getBlock() instanceof CabinetBlock && (dir1 = state1.getValue(FACING)).getAxis() != state.getValue(FACING).getAxis() && isDifferentOrientation(state, level, pos, dir1.getOpposite())) {
            if (dir1 == facing.getCounterClockWise()) {
                return CabinetType.INNER_LEFT;
            }
            return CabinetType.INNER_RIGHT;
        }

        Direction dir2;
        BlockState state2 = level.getBlockState(pos.relative(facing.getOpposite()));
        if (state2.getBlock() instanceof CabinetBlock && (dir2 = state2.getValue(FACING)).getAxis() != state.getValue(FACING).getAxis() && isDifferentOrientation(state, level, pos, dir2)) {
            if (dir2 == facing.getCounterClockWise()) {
                return CabinetType.OUTER_LEFT;
            }
            return CabinetType.OUTER_RIGHT;
        }

        boolean left = canConnect(level, pos, state.getValue(FACING).getCounterClockWise());
        boolean right = canConnect(level, pos, state.getValue(FACING).getClockWise());
        if (left && right) {
            return CabinetType.MIDDLE;
        }
        else if (left) {
            return CabinetType.LEFT;
        }
        else if (right) {
            return CabinetType.RIGHT;
        }
        return CabinetType.SINGLE;
    }

    public static boolean canConnect(Level level, BlockPos pos, Direction direction) {
        BlockState state = level.getBlockState(pos.relative(direction));
        return state.getBlock() instanceof CabinetBlock;
    }

    public static boolean isDifferentOrientation(BlockState state, Level level, BlockPos pos, Direction dir) {
        BlockState blockState = level.getBlockState(pos.relative(dir));
        return !(blockState.getBlock() instanceof CabinetBlock) || blockState.getValue(FACING) != state.getValue(FACING);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
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
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL; // Critical for visibility
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.connectable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.lockable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.hammerable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltip, flag);
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LockableBlockEntity(pos, state);
    }
}