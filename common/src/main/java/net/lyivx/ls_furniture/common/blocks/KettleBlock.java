package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class KettleBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected static final VoxelShape NORTH = Stream.of(
            Block.box(6, 0, 9, 10, 2, 13),
            Block.box(10, 0, 9, 11, 2, 13),
            Block.box(5, 0, 9, 6, 2, 13),
            Block.box(6, 0, 8, 10, 2, 9),
            Block.box(6, 0, 13, 10, 2, 14),
            Block.box(6, 2, 13, 10, 10, 14),
            Block.box(6, 2, 9, 10, 9, 13),
            Block.box(6, 10, 9, 10, 11, 13),
            Block.box(10, 10, 10.5, 12, 11, 11.5),
            Block.box(4, 8, 10.5, 5, 9, 11.5),
            Block.box(4, 3, 10.5, 5, 4, 11.5),
            Block.box(3, 3, 10.5, 4, 9, 11.5),
            Block.box(10, 2, 9, 11, 10, 13),
            Block.box(5, 2, 9, 6, 10, 13),
            Block.box(6, 2, 8, 10, 10, 9),
            Block.box(3, 1, 10, 6, 2, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public KettleBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    private static final VoxelShape[] SHAPES = new VoxelShape[4];

    static {
        SHAPES[0] = ShapeUtil.rotateShape(NORTH, Direction.SOUTH); //South
        SHAPES[1] = ShapeUtil.rotateShape(NORTH, Direction.WEST); //West
        SHAPES[2] = ShapeUtil.rotateShape(NORTH, Direction.NORTH); //North
        SHAPES[3] = ShapeUtil.rotateShape(NORTH, Direction.EAST); //East
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);

        return SHAPES[direction.get2DDataValue()];
    }
}
