package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class BushBlock extends CrossCollisionBlock {
    public static final MapCodec<BushBlock> CODEC = simpleCodec(BushBlock::new);

    public BushBlock(Properties properties)
    {
        super(3, 3, 16, 16, 24, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random)
    {
        return this.getHedgeState(state, level, pos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.getHedgeState(this.defaultBlockState(), context.getLevel(), context.getClickedPos());
    }

    private BlockState getHedgeState(BlockState state, LevelReader level, BlockPos pos)
    {
        FluidState fluid = level.getFluidState(pos);
        boolean north = this.canConnectToFace(level, pos, Direction.NORTH);
        boolean east = this.canConnectToFace(level, pos, Direction.EAST);
        boolean south = this.canConnectToFace(level, pos, Direction.SOUTH);
        boolean west = this.canConnectToFace(level, pos, Direction.WEST);
        return state.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    private boolean canConnectToFace(LevelReader level, BlockPos pos, Direction direction)
    {
        pos = pos.relative(direction);
        BlockState state = level.getBlockState(pos);
        return !isExceptionForConnection(state) && state.isFaceSturdy(level, pos, direction.getOpposite()) || state.getBlock() instanceof BushBlock || state.getBlock() instanceof LeavesBlock;
    }

    @Override
    protected MapCodec<? extends CrossCollisionBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type)
    {
        return false;
    }

    @Deprecated
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos)
    {
        return 1;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
