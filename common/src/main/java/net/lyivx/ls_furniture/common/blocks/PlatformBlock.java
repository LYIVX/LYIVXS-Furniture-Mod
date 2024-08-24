package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.lyivx.ls_furniture.registry.ModBlocksTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
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
import java.util.stream.Stream;

import static net.lyivx.ls_furniture.common.blocks.ModStairBlock.MODEL_TYPE;

public class PlatformBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty NORTH_1 = ModBlockStateProperties.NORTH_PLATFORM;
    public static final BooleanProperty EAST_1 = ModBlockStateProperties.EAST_PLATFORM;
    public static final BooleanProperty SOUTH_1 = ModBlockStateProperties.SOUTH_PLATFORM;
    public static final BooleanProperty WEST_1 = ModBlockStateProperties.WEST_PLATFORM;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty UPDATE = ModBlockStateProperties.UPDATE;

    protected static final VoxelShape BOTTOM = Block.box(0, 0, 0, 16, 1, 16);
    protected static final VoxelShape NORTH_S = Stream.of(Block.box(14, 1, 0, 16, 14, 2), Block.box(0, 1, 0, 2, 14, 2), Block.box(2, 14, 0, 14, 16, 2), Block.box(1, 14, 0, 2, 15, 2), Block.box(14, 14, 0, 15, 15, 2)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape EAST_S = ShapeUtil.rotateShape(NORTH_S, Direction.EAST);
    protected static final VoxelShape SOUTH_S = ShapeUtil.rotateShape(NORTH_S, Direction.SOUTH);
    protected static final VoxelShape WEST_S = ShapeUtil.rotateShape(NORTH_S, Direction.WEST);
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            BOTTOM,
            Shapes.or(BOTTOM, NORTH_S),
            Shapes.or(BOTTOM, EAST_S),
            Shapes.or(BOTTOM, NORTH_S, EAST_S),
            Shapes.or(BOTTOM, SOUTH_S),
            Shapes.or(BOTTOM, NORTH_S, SOUTH_S),
            Shapes.or(BOTTOM, EAST_S, SOUTH_S),
            Shapes.or(BOTTOM, NORTH_S, EAST_S, SOUTH_S),
            Shapes.or(BOTTOM, WEST_S),
            Shapes.or(BOTTOM, NORTH_S, WEST_S),
            Shapes.or(BOTTOM, EAST_S, WEST_S),
            Shapes.or(BOTTOM, NORTH_S, EAST_S, WEST_S),
            Shapes.or(BOTTOM, SOUTH_S, WEST_S),
            Shapes.or(BOTTOM, NORTH_S, SOUTH_S, WEST_S),
            Shapes.or(BOTTOM, EAST_S, SOUTH_S, WEST_S),
            Shapes.or(BOTTOM, NORTH_S, EAST_S, SOUTH_S, WEST_S)
    };

    public PlatformBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(NORTH_1, true)
                .setValue(EAST_1, true)
                .setValue(SOUTH_1, true)
                .setValue(WEST_1, true)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int shape = 0;
        if (state.getValue(NORTH_1)) shape += 1;
        if (state.getValue(EAST_1)) shape += 2;
        if (state.getValue(SOUTH_1)) shape += 4;
        if (state.getValue(WEST_1)) shape += 8;
        return SHAPES[shape];
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        BlockState state = this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, waterlogged);
        return getConnections(state, context.getLevel(), context.getClickedPos());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        BlockEntity blockEntity = level.getBlockEntity(currentPos);
        if (blockEntity instanceof ILockable lockable && lockable.isLocked()) {
            return state; // Return the current state if the block is locked
        }

        return getConnections(state, level, currentPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, NORTH_1, EAST_1, SOUTH_1, WEST_1, UPDATE, WATERLOGGED);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();

        if (item instanceof HammerItem || item instanceof WrenchItem) {
            return InteractionResult.FAIL;
        }

        if (!(item instanceof BlockItem blockItem)) {
            return InteractionResult.FAIL;
        }

        Block blockInHand = blockItem.getBlock();
        if (!(blockInHand instanceof PlatformBlock || blockInHand instanceof ModStairBlock)) {
            return InteractionResult.FAIL;
        }

        if (hit.getDirection() != Direction.UP) {
            return InteractionResult.FAIL;
        }

        Direction playerFacing = player.getDirection();
        BlockPos targetPos = pos.relative(playerFacing);

        if (!canPlaceBlock(level, targetPos)) {
            return InteractionResult.FAIL;
        }

        if (blockInHand instanceof ModStairBlock) {
            return placeStairBlock(level, targetPos, blockInHand, playerFacing, player, stack);
        } else if (blockInHand instanceof PlatformBlock) {
            return placePlatformBlock(level, targetPos, blockInHand, state.getValue(FACING), player, stack);
        }

        return InteractionResult.SUCCESS;
    }

    private boolean canPlaceBlock(Level level, BlockPos targetPos) {
        return level.getBlockState(targetPos).canBeReplaced() &&
                level.getBlockState(targetPos.above()).canBeReplaced();
    }

    private InteractionResult placeStairBlock(Level level, BlockPos pos, Block block, Direction playerFacing, Player player, ItemStack stack) {
        BlockState newState = block.defaultBlockState()
                .setValue(FACING, playerFacing.getOpposite())
                .setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);

        BlockState typeNewState = block.defaultBlockState()
                .setValue(FACING, playerFacing.getOpposite())
                .setValue(MODEL_TYPE, ModStairBlock.StairModelType.TOP)
                .setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);

        level.setBlock(pos, newState, 3);
        level.setBlock(pos.above(), typeNewState, 3);
        playPlaceSound(level, pos, block);
        if (!player.isCreative()) {
            stack.shrink(1);
        }
        newState.updateNeighbourShapes(level, pos, 3);
        return InteractionResult.SUCCESS;
    }

    private InteractionResult placePlatformBlock(Level level, BlockPos pos, Block block, Direction blockFacing, Player player, ItemStack stack) {
        BlockState newState = block.defaultBlockState()
                .setValue(FACING, blockFacing)
                .setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);

        level.setBlock(pos, newState, 3);
        playPlaceSound(level, pos, block);
        if (!player.isCreative()) {
            stack.shrink(1);
        }
        newState.updateNeighbourShapes(level, pos, 3);
        return InteractionResult.SUCCESS;
    }

    private void playPlaceSound(Level level, BlockPos pos, Block block) {
        SoundType soundType = block.getSoundType(block.defaultBlockState());
        level.playSound(null, pos, soundType.getPlaceSound(), SoundSource.BLOCKS,
                (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        boolean north_1 = state.getValue(NORTH_1);
        boolean east_1 = state.getValue(EAST_1);
        boolean south_1 = state.getValue(SOUTH_1);
        boolean west_1 = state.getValue(WEST_1);
        return switch(rotation) {
            case NONE -> state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
            case CLOCKWISE_90 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(NORTH_1, west_1)
                    .setValue(EAST_1, north_1)
                    .setValue(SOUTH_1, east_1)
                    .setValue(WEST_1, south_1);
            case CLOCKWISE_180 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(NORTH_1, south_1)
                    .setValue(EAST_1, west_1)
                    .setValue(SOUTH_1, north_1).setValue(WEST_1, east_1);
            case COUNTERCLOCKWISE_90 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(NORTH_1, east_1)
                    .setValue(EAST_1, south_1)
                    .setValue(SOUTH_1, west_1)
                    .setValue(WEST_1, north_1);
        };
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    public BlockState getConnections(BlockState state, LevelAccessor level, BlockPos pos) {
        boolean north = validConnection(level.getBlockState(pos.north()));
        boolean east = validConnection(level.getBlockState(pos.east()));
        boolean south = validConnection(level.getBlockState(pos.south()));
        boolean west = validConnection(level.getBlockState(pos.west()));
        boolean north_1 = (!north) || !(validConnection(level.getBlockState(pos.north().south())));
        boolean east_1 = (!east) || !(validConnection(level.getBlockState(pos.east().west())));
        boolean south_1 = (!south) || !(validConnection(level.getBlockState(pos.south().north())));
        boolean west_1 = (!west) || !(validConnection(level.getBlockState(pos.west().east())));
        boolean update = ((north ? 1 : 0) + (east ? 1 : 0) + (south ? 1 : 0) + (west ? 1 : 0)) % 2 == 0;
        return state.setValue(NORTH_1, north_1).setValue(EAST_1, east_1).setValue(SOUTH_1, south_1).setValue(WEST_1, west_1).setValue(UPDATE, update);
    }

    public boolean validConnection(BlockState state) {
        return state.is(ModBlocksTags.PLATFORMS_CONNECTABLE);
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
        return List.of(NORTH_1, EAST_1, SOUTH_1, WEST_1);
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