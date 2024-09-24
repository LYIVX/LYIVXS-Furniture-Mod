package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.blocks.properties.VerticalConnectionType;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class FirePlaceChimneyShaftBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock {
    public static final MapCodec<FirePlaceChimneyShaftBlock> CODEC = simpleCodec(FirePlaceChimneyShaftBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<VerticalConnectionType> VERTICAL = ModBlockStateProperties.VERTICAL_CONNECTION_TYPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape NORTH_SINGLE = Stream.of(
            Block.box(3, 1, 12, 13, 15, 16),
            Block.box(2, 0, 12, 14, 1, 16),
            Block.box(2, 15, 12, 14, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape NORTH_TOP =
            Shapes.join(Block.box(3, 0, 12, 13, 15, 16),
            Block.box(2, 15, 12, 14, 16, 16), BooleanOp.OR);
    protected static final VoxelShape NORTH_MIDDLE =
            Block.box(3, 0, 12, 13, 16, 16);
    protected static final VoxelShape NORTH_BOTTOM =
            Shapes.join(Block.box(3, 1, 12, 13, 16, 16),
            Block.box(2, 0, 12, 14, 1, 16), BooleanOp.OR);


    public FirePlaceChimneyShaftBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(VERTICAL, VerticalConnectionType.SINGLE)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    private static final VoxelShape[] SHAPES_SINGLE = new VoxelShape[4];
    static {
        SHAPES_SINGLE[0] = ShapeUtil.rotateShape(NORTH_SINGLE, Direction.SOUTH); //South
        SHAPES_SINGLE[1] = ShapeUtil.rotateShape(NORTH_SINGLE, Direction.WEST); //West
        SHAPES_SINGLE[2] = ShapeUtil.rotateShape(NORTH_SINGLE, Direction.NORTH); //North
        SHAPES_SINGLE[3] = ShapeUtil.rotateShape(NORTH_SINGLE, Direction.EAST); //East
    }
    private static final VoxelShape[] SHAPES_TOP = new VoxelShape[4];
    static {
        SHAPES_TOP[0] = ShapeUtil.rotateShape(NORTH_TOP, Direction.SOUTH); //South
        SHAPES_TOP[1] = ShapeUtil.rotateShape(NORTH_TOP, Direction.WEST); //West
        SHAPES_TOP[2] = ShapeUtil.rotateShape(NORTH_TOP, Direction.NORTH); //North
        SHAPES_TOP[3] = ShapeUtil.rotateShape(NORTH_TOP, Direction.EAST); //East
    }
    private static final VoxelShape[] SHAPES_MIDDLE = new VoxelShape[4];
    static {
        SHAPES_MIDDLE[0] = ShapeUtil.rotateShape(NORTH_MIDDLE, Direction.SOUTH); //South
        SHAPES_MIDDLE[1] = ShapeUtil.rotateShape(NORTH_MIDDLE, Direction.WEST); //West
        SHAPES_MIDDLE[2] = ShapeUtil.rotateShape(NORTH_MIDDLE, Direction.NORTH); //North
        SHAPES_MIDDLE[3] = ShapeUtil.rotateShape(NORTH_MIDDLE, Direction.EAST); //East
    }
    private static final VoxelShape[] SHAPES_BOTTOM = new VoxelShape[4];
    static {
        SHAPES_BOTTOM[0] = ShapeUtil.rotateShape(NORTH_BOTTOM, Direction.SOUTH); //South
        SHAPES_BOTTOM[1] = ShapeUtil.rotateShape(NORTH_BOTTOM, Direction.WEST); //West
        SHAPES_BOTTOM[2] = ShapeUtil.rotateShape(NORTH_BOTTOM, Direction.NORTH); //North
        SHAPES_BOTTOM[3] = ShapeUtil.rotateShape(NORTH_BOTTOM, Direction.EAST); //East
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        if (state.getValue(VERTICAL) == VerticalConnectionType.SINGLE) {
            return SHAPES_SINGLE[direction.get2DDataValue()];

        } else if (state.getValue(VERTICAL) == VerticalConnectionType.TOP) {
            return SHAPES_TOP[direction.get2DDataValue()];

        } else if (state.getValue(VERTICAL) == VerticalConnectionType.MIDDLE) {
            return SHAPES_MIDDLE[direction.get2DDataValue()];

        } else if (state.getValue(VERTICAL) == VerticalConnectionType.BOTTOM) {
            return SHAPES_BOTTOM[direction.get2DDataValue()];

        }
        return SHAPES_SINGLE[direction.get2DDataValue()];
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();
        BlockState state = this.defaultBlockState().setValue(FACING, facing);
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();

        return state
                .setValue(VERTICAL, getType(state, level.getBlockState(clickedPos.above()), level.getBlockState(clickedPos.below())))
                .setValue(WATERLOGGED, level.getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (level.isClientSide) return;

        if (level.getBlockEntity(pos) instanceof LockableBlockEntity lockable && !lockable.isLocked()) {

            VerticalConnectionType type = getType(state, level.getBlockState(pos.above()), level.getBlockState(pos.below()));
            state = state.setValue(VERTICAL, type);
            level.setBlock(pos, state, 3);

            super.neighborChanged(state, level, pos, block, fromPos, isMoving);
        }
    }

    public VerticalConnectionType getType(BlockState state, BlockState above, BlockState below) {
        boolean up = isConnected(state, above);
        boolean down = isConnected(state, below);

        if (up && down) return VerticalConnectionType.MIDDLE;
        else if (up) return VerticalConnectionType.BOTTOM;
        else if (down) return VerticalConnectionType.TOP;
        return VerticalConnectionType.SINGLE;
    }

    public boolean isConnected(BlockState state, BlockState other) {
        return other.is(state.getBlock())
                //&& other.getValue(VERTICAL) == state.getValue(VERTICAL)
                && other.getValue(FACING) == state.getValue(FACING);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, VERTICAL, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        BlockEntity blockEntity = level.getBlockEntity(currentPos);
        if (blockEntity instanceof ILockable lockable && lockable.isLocked()) {
            return state; // Return the current state if the block is locked
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
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
            tooltip.add(Component.translatable("tooltip.ls_furniture.lockable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.hammerable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }

    @Override
    public List<Property<?>> getHammerableProperties() {
        return List.of(VERTICAL);
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

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}