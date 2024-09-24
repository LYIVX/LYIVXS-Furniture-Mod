package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.entity.ShelfBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.HorizontalConnectionType;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.common.utils.block.BlockPart;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShelfBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock {
    public static final EnumProperty<HorizontalConnectionType> SHAPE = ModBlockStateProperties.HORIZONTAL_CONNECTION_TYPE;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape TOP = Block.box(0, 14, 8, 16, 16, 16);
    protected static final VoxelShape NR = Shapes.join(Block.box(1.5, 10, 14, 3.5, 14, 16), Block.box(2, 12, 12, 3, 14, 14), BooleanOp.OR);
    protected static final VoxelShape NL = Shapes.join(Block.box(12.5, 10, 14, 14.5, 14, 16), Block.box(13, 12, 12, 14, 14, 14), BooleanOp.OR);

    protected static final VoxelShape T_NL = Shapes.or(TOP, NL);
    protected static final VoxelShape T_NR = Shapes.or(TOP, NR);
    protected static final VoxelShape T_NLR = Shapes.or(TOP, NL, NR);
    protected static final VoxelShape T_EL = ShapeUtil.rotateShape(T_NL, Direction.EAST);
    protected static final VoxelShape T_ER = ShapeUtil.rotateShape(T_NR, Direction.EAST);
    protected static final VoxelShape T_ELR = ShapeUtil.rotateShape(T_NLR, Direction.EAST);
    protected static final VoxelShape T_SL = ShapeUtil.rotateShape(T_NL, Direction.SOUTH);
    protected static final VoxelShape T_SR = ShapeUtil.rotateShape(T_NR, Direction.SOUTH);
    protected static final VoxelShape T_SLR = ShapeUtil.rotateShape(T_NLR, Direction.SOUTH);
    protected static final VoxelShape T_WL = ShapeUtil.rotateShape(T_NL, Direction.WEST);
    protected static final VoxelShape T_WR = ShapeUtil.rotateShape(T_NR, Direction.WEST);
    protected static final VoxelShape T_WLR = ShapeUtil.rotateShape(T_NLR, Direction.WEST);

    public ShelfBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SHAPE, HorizontalConnectionType.SINGLE)
                .setValue(WATERLOGGED, false)
        );
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (hit.getDirection() != Direction.UP) return InteractionResult.PASS;
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (!(blockentity instanceof ShelfBlockEntity shelfBE)) return InteractionResult.PASS;

        Direction facing = state.getValue(FACING);
        int slot = BlockPart.get1D(pos, hit.getLocation(), facing.getClockWise(), 6);

        // Place
        ItemStack stack = player.getItemInHand(hand);
        if (!stack.isEmpty()) {
            if (!level.isClientSide && shelfBE.placeItem(player.getAbilities().instabuild ? stack.copy() : stack, slot)) {
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            }
            // Avoids client trying to place actual block on top
            return InteractionResult.CONSUME;
        }

        // Remove
        if (shelfBE.removeItem(slot, player, level)) return InteractionResult.SUCCESS;

        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.is(newState.getBlock())) return;

        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof ShelfBlockEntity shelfBE) Containers.dropContents(level, pos, shelfBE.getItems());
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        HorizontalConnectionType type = state.getValue(SHAPE);

        if (direction == Direction.NORTH) {
            return switch (type) {
                case SINGLE -> T_NLR;
                case LEFT -> T_NL;
                case RIGHT -> T_NR;
                default -> ShapeUtil.rotateShape(TOP, Direction.NORTH);
            };
        } else if (direction == Direction.EAST) {
            return switch (type) {
                case SINGLE -> T_ELR;
                case LEFT -> T_EL;
                case RIGHT -> T_ER;
                default -> ShapeUtil.rotateShape(TOP, Direction.EAST);
            };
        } else if (direction == Direction.SOUTH) {
            return switch (type) {
                case SINGLE -> T_SLR;
                case LEFT -> T_SL;
                case RIGHT -> T_SR;
                default -> ShapeUtil.rotateShape(TOP, Direction.SOUTH);
            };
        } else {
            return switch (type) {
                case SINGLE -> T_WLR;
                case LEFT -> T_WL;
                case RIGHT -> T_WR;
                default -> ShapeUtil.rotateShape(TOP, Direction.WEST);
            };
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL; // Critical for visibility
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, waterlogged);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        BlockEntity blockEntity = level.getBlockEntity(currentPos);
        if (blockEntity instanceof ILockable lockable && lockable.isLocked()) {
            return state; // Return the current state if the block is locked
        }

        BlockState above = level.getBlockState(currentPos.above());
        if (direction == Direction.UP && (above.isFaceSturdy(level, currentPos, Direction.DOWN) && !above.getVisualShape(level, currentPos.above(), CollisionContext.empty()).isEmpty())) {
            if (level.getBlockEntity(currentPos) instanceof ShelfBlockEntity shelfBE) shelfBE.removeAllItems();
        }

        Direction facing = state.getValue(FACING);
        Direction dirL = facing.getClockWise();
        Direction dirR = facing.getCounterClockWise();
        if (direction != dirL && direction != dirR) return state;

        BlockState l_state = level.getBlockState(currentPos.relative(dirL));
        BlockState r_state = level.getBlockState(currentPos.relative(dirR));
        boolean l_side = l_state.getBlock() instanceof ShelfBlock && l_state.getValue(FACING) == facing;
        boolean r_side = r_state.getBlock() instanceof ShelfBlock && r_state.getValue(FACING) == facing;
        HorizontalConnectionType type = l_side && r_side ?
                HorizontalConnectionType.MIDDLE
                : (r_side ? HorizontalConnectionType.LEFT
                : (l_side ? HorizontalConnectionType.RIGHT
                : HorizontalConnectionType.SINGLE));
        return state.setValue(SHAPE, type);
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE, WATERLOGGED);
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
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
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
}