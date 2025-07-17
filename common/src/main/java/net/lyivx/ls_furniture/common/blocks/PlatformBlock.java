package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
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
import net.minecraft.world.ItemInteractionResult;
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
    public static final MapCodec<PlatformBlock> CODEC = simpleCodec(PlatformBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty NORTH_PLATFORM = ModBlockStateProperties.NORTH_PLATFORM;
    public static final BooleanProperty EAST_PLATFORM = ModBlockStateProperties.EAST_PLATFORM;
    public static final BooleanProperty SOUTH_PLATFORM = ModBlockStateProperties.SOUTH_PLATFORM;
    public static final BooleanProperty WEST_PLATFORM = ModBlockStateProperties.WEST_PLATFORM;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty UPDATE = ModBlockStateProperties.UPDATE;

    protected static final VoxelShape BOTTOM = Block.box(0, 0, 0, 16, 1, 16);
    protected static final VoxelShape PLATFORM_NORTH = Stream.of(
            Block.box(0, 14, 0, 16, 16, 2),
            Block.box(3, 1, 0, 5, 14, 2),
            Block.box(11, 1, 0, 13, 14, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape PLATFORM_EAST = ShapeUtil.rotateShape(PLATFORM_NORTH, Direction.EAST);
    protected static final VoxelShape PLATFORM_SOUTH = ShapeUtil.rotateShape(PLATFORM_NORTH, Direction.SOUTH);
    protected static final VoxelShape PLATFORM_WEST = ShapeUtil.rotateShape(PLATFORM_NORTH, Direction.WEST);
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            BOTTOM,
            Shapes.or(BOTTOM, PLATFORM_NORTH),
            Shapes.or(BOTTOM, PLATFORM_EAST),
            Shapes.or(BOTTOM, PLATFORM_NORTH, PLATFORM_EAST),
            Shapes.or(BOTTOM, PLATFORM_SOUTH),
            Shapes.or(BOTTOM, PLATFORM_NORTH, PLATFORM_SOUTH),
            Shapes.or(BOTTOM, PLATFORM_EAST, PLATFORM_SOUTH),
            Shapes.or(BOTTOM, PLATFORM_NORTH, PLATFORM_EAST, PLATFORM_SOUTH),
            Shapes.or(BOTTOM, PLATFORM_WEST),
            Shapes.or(BOTTOM, PLATFORM_NORTH, PLATFORM_WEST),
            Shapes.or(BOTTOM, PLATFORM_EAST, PLATFORM_WEST),
            Shapes.or(BOTTOM, PLATFORM_NORTH, PLATFORM_EAST, PLATFORM_WEST),
            Shapes.or(BOTTOM, PLATFORM_SOUTH, PLATFORM_WEST),
            Shapes.or(BOTTOM, PLATFORM_NORTH, PLATFORM_SOUTH, PLATFORM_WEST),
            Shapes.or(BOTTOM, PLATFORM_EAST, PLATFORM_SOUTH, PLATFORM_WEST),
            Shapes.or(BOTTOM, PLATFORM_NORTH, PLATFORM_EAST, PLATFORM_SOUTH, PLATFORM_WEST)
    };

    public PlatformBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(NORTH_PLATFORM, true)
                .setValue(EAST_PLATFORM, true)
                .setValue(SOUTH_PLATFORM, true)
                .setValue(WEST_PLATFORM, true)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int shape = 0;
        if (state.getValue(NORTH_PLATFORM)) shape += 1;
        if (state.getValue(EAST_PLATFORM)) shape += 2;
        if (state.getValue(SOUTH_PLATFORM)) shape += 4;
        if (state.getValue(WEST_PLATFORM)) shape += 8;
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
        builder.add(FACING, NORTH_PLATFORM, EAST_PLATFORM, SOUTH_PLATFORM, WEST_PLATFORM, UPDATE, WATERLOGGED);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();

        if (item instanceof HammerItem || item instanceof WrenchItem) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        if (!(item instanceof BlockItem blockItem)) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        Block blockInHand = blockItem.getBlock();
        if (!(blockInHand instanceof PlatformBlock || blockInHand instanceof ModStairBlock)) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        if (hitResult.getDirection() != Direction.UP) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        Direction playerFacing = player.getDirection();
        BlockPos targetPos = pos.relative(playerFacing);

        if (!canPlaceBlock(level, targetPos)) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        if (blockInHand instanceof ModStairBlock) {
            return placeStairBlock(level, targetPos, blockInHand, playerFacing, player, stack);
        } else if (blockInHand instanceof PlatformBlock) {
            return placePlatformBlock(level, targetPos, blockInHand, state.getValue(FACING), player, stack);
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        return ItemInteractionResult.SUCCESS;
    }

    private boolean canPlaceBlock(Level level, BlockPos targetPos) {
        return level.getBlockState(targetPos).canBeReplaced() &&
                level.getBlockState(targetPos.above()).canBeReplaced();
    }

    private ItemInteractionResult placeStairBlock(Level level, BlockPos pos, Block block, Direction playerFacing, Player player, ItemStack stack) {
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
        return ItemInteractionResult.SUCCESS;
    }

    private ItemInteractionResult placePlatformBlock(Level level, BlockPos pos, Block block, Direction blockFacing, Player player, ItemStack stack) {
        BlockState newState = block.defaultBlockState()
                .setValue(FACING, blockFacing)
                .setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);

        level.setBlock(pos, newState, 3);
        playPlaceSound(level, pos, block);
        if (!player.isCreative()) {
            stack.shrink(1);
        }
        newState.updateNeighbourShapes(level, pos, 3);
        return ItemInteractionResult.SUCCESS;
    }

    private void playPlaceSound(Level level, BlockPos pos, Block block) {
        SoundType soundType = block.defaultBlockState().getSoundType();
        level.playSound(null, pos, soundType.getPlaceSound(), SoundSource.BLOCKS,
                (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        boolean north_1 = state.getValue(NORTH_PLATFORM);
        boolean east_1 = state.getValue(EAST_PLATFORM);
        boolean south_1 = state.getValue(SOUTH_PLATFORM);
        boolean west_1 = state.getValue(WEST_PLATFORM);
        return switch(rotation) {
            case NONE -> state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
            case CLOCKWISE_90 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(NORTH_PLATFORM, west_1)
                    .setValue(EAST_PLATFORM, north_1)
                    .setValue(SOUTH_PLATFORM, east_1)
                    .setValue(WEST_PLATFORM, south_1);
            case CLOCKWISE_180 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(NORTH_PLATFORM, south_1)
                    .setValue(EAST_PLATFORM, west_1)
                    .setValue(SOUTH_PLATFORM, north_1).setValue(WEST_PLATFORM, east_1);
            case COUNTERCLOCKWISE_90 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(NORTH_PLATFORM, east_1)
                    .setValue(EAST_PLATFORM, south_1)
                    .setValue(SOUTH_PLATFORM, west_1)
                    .setValue(WEST_PLATFORM, north_1);
        };
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
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
        return state.setValue(NORTH_PLATFORM, north_1).setValue(EAST_PLATFORM, east_1).setValue(SOUTH_PLATFORM, south_1).setValue(WEST_PLATFORM, west_1).setValue(UPDATE, update);
    }

    public boolean validConnection(BlockState state) {
        return state.is(ModBlocksTags.PLATFORMS_CONNECTABLE);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL; // Critical for visibility
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
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
        super.appendHoverText(stack, context, tooltip, flag);
    }

    public List<Property<?>> getHammerableProperties() {
        return List.of(NORTH_PLATFORM, EAST_PLATFORM, SOUTH_PLATFORM, WEST_PLATFORM);
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