package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ColorType;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.blocks.properties.VerticalConnectionType;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.registry.ModItemTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
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

public class LampBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock {
    public static final MapCodec<LampBlock> CODEC = simpleCodec(LampBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final DirectionProperty FACING = ModBlockStateProperties.FACING_EXCEPT_DOWN;
    public static final EnumProperty<VerticalConnectionType> VERTICAL = ModBlockStateProperties.VERTICAL_CONNECTION_TYPE;
    public static final EnumProperty<ColorType> COLOR = ModBlockStateProperties.COLOR;

    protected static final VoxelShape SINGLE = Stream.of(
            Block.box(7, 4, 7, 9, 10, 9),
            Block.box(7, 10, 7, 9, 12, 9),
            Block.box(12, 6, 4, 13, 13, 12),
            Block.box(3, 6, 4, 4, 13, 12),
            Block.box(3, 6, 12, 13, 13, 13),
            Block.box(4, 12, 6, 6, 15, 10),
            Block.box(10, 12, 6, 12, 15, 10),
            Block.box(4, 12, 10, 12, 15, 12),
            Block.box(4, 12, 4, 12, 15, 6),
            Block.box(3, 6, 3, 13, 13, 4),
            Block.box(6, 0, 6, 10, 4, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape BOTTOM = Shapes.join(Block.box(7, 4, 7, 9, 16, 9), Block.box(6, 0, 6, 10, 4, 10), BooleanOp.OR);
    protected static final VoxelShape MIDDLE = Block.box(7, 0, 7, 9, 16, 9);
    protected static final VoxelShape TOP = Stream.of(
            Block.box(7, 10, 7, 9, 12, 9),
            Block.box(12, 6, 4, 13, 13, 12),
            Block.box(3, 6, 4, 4, 13, 12),
            Block.box(3, 6, 12, 13, 13, 13),
            Block.box(4, 12, 6, 6, 15, 10),
            Block.box(10, 12, 6, 12, 15, 10),
            Block.box(4, 12, 10, 12, 15, 12),
            Block.box(4, 12, 4, 12, 15, 6),
            Block.box(3, 6, 3, 13, 13, 4),
            Block.box(7, 0, 7, 9, 10, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape WALL_NORTH = Stream.of(
            Block.box(7, 10, 9, 9, 12, 11),
            Block.box(7, 2, 11, 9, 4, 14),
            Block.box(7, 2, 9, 9, 10, 11),
            Block.box(5, 0, 14, 11, 6, 16),
            Block.box(12, 6, 6, 13, 13, 14),
            Block.box(3, 6, 6, 4, 13, 14),
            Block.box(3, 6, 14, 13, 13, 15),
            Block.box(4, 12, 8, 6, 15, 12),
            Block.box(10, 12, 8, 12, 15, 12),
            Block.box(4, 12, 12, 12, 15, 14),
            Block.box(4, 12, 6, 12, 15, 8),
            Block.box(3, 6, 5, 13, 13, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public LampBlock(Properties properties) {
        super(properties.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.UP)
                .setValue(LIT, false)
                .setValue(POWERED, false)
                .setValue(WATERLOGGED, false)
                .setValue(VERTICAL, VerticalConnectionType.SINGLE)
                .setValue(COLOR, ColorType.WHITE));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }


    private static final VoxelShape[] WALL = new VoxelShape[4];

    static {
        WALL[0] = ShapeUtil.rotateShape(WALL_NORTH, Direction.SOUTH); //South
        WALL[1] = ShapeUtil.rotateShape(WALL_NORTH, Direction.WEST); //West
        WALL[2] = ShapeUtil.rotateShape(WALL_NORTH, Direction.NORTH); //North
        WALL[3] = ShapeUtil.rotateShape(WALL_NORTH, Direction.EAST); //East
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        VerticalConnectionType verticalType = state.getValue(VERTICAL);

        if (direction == null) {
            throw new IllegalStateException("Direction must not be null.");
        }

        switch (verticalType) {
            case SINGLE:
                if (direction == Direction.NORTH || direction == Direction.SOUTH ||
                        direction == Direction.EAST || direction == Direction.WEST) {
                    return WALL[direction.get2DDataValue()];
                }
            case TOP:
                return TOP;
            case MIDDLE:
                return MIDDLE;
            case BOTTOM:
                return BOTTOM;
            default:
                return SINGLE;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        Direction clickedFace = context.getClickedFace();
        BlockState blockstate = this.defaultBlockState();
        if (level.hasNeighborSignal(pos)) {
            blockstate = blockstate.setValue(POWERED, true);
        }
        return clickedFace != Direction.DOWN ? blockstate.setValue(FACING, clickedFace).setValue(WATERLOGGED, waterlogged) : null;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (!state.canSurvive(level, currentPos)) return Blocks.AIR.defaultBlockState();

        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        if (state.getValue(FACING) == Direction.UP && (direction == Direction.UP || direction == Direction.DOWN)) {
            return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
        }
        return state;
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos facingPos = pos.relative(direction.getOpposite());
        BlockState facingState = level.getBlockState(facingPos);
        return direction == Direction.UP || facingState.isFaceSturdy(level, facingPos, direction);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (level.isClientSide) return;

        BlockState below = level.getBlockState(pos.below());
        boolean powered = level.hasNeighborSignal(pos) || (below.getBlock() instanceof LampBlock && below.getValue(POWERED));
        if (powered != state.getValue(POWERED)) {
            if (state.getValue(LIT) != powered) {
                state = state.setValue(LIT, powered);
                level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
            state = state.setValue(POWERED, powered);
        }

        level.setBlock(pos, state, 3);

        VerticalConnectionType type = getType(state, level.getBlockState(pos.above()), level.getBlockState(pos.below()));
        state = state.setValue(VERTICAL, type);
        level.setBlock(pos, state, 3);
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
                && other.getValue(FACING) == state.getValue(FACING);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);

        BlockState below = level.getBlockState(pos.below());
        BlockState above = level.getBlockState(pos.above());

        ColorType colorBelow = (below.getBlock() instanceof LampBlock) ? below.getValue(COLOR) : null;
        ColorType colorAbove = (above.getBlock() instanceof LampBlock) ? above.getValue(COLOR) : null;

        ColorType newColor = state.getValue(COLOR);
        boolean shouldDropDye = false;

        if (colorBelow != null && colorBelow.equals(ColorType.WHITE) && colorAbove != null) {
            newColor = colorAbove;
        }
        else if (colorBelow != null && !colorBelow.equals(ColorType.WHITE)) {
            newColor = colorBelow;
            if (colorAbove != null && !colorBelow.equals(colorAbove)) {
                shouldDropDye = true;
            }
        }
        else if (colorAbove != null) {
            newColor = colorAbove;
        }

        if (newColor != null && !newColor.equals(state.getValue(COLOR))) {
            state = state.setValue(COLOR, newColor);
            level.setBlock(pos, state, Block.UPDATE_ALL);
            updateBlockEntityColor(level, pos, state);

            if (shouldDropDye && colorAbove != null && !colorBelow.equals(ColorType.WHITE)) {
                ItemStack dyeItem = colorAbove.getDyeItemStack();
                if (!dyeItem.isEmpty()) {
                    popResource(level, pos.above(), dyeItem);
                }
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);
        if (state.getBlock() != newState.getBlock()) {
            updateBlockEntityColor(level, pos, state);
        }
    }

    private void updateBlockEntityColor(Level level, BlockPos pos, BlockState state) {
        ColorType color = state.getValue(COLOR);
        state.setValue(COLOR, color);
        level.sendBlockUpdated(pos, state, state, 3);

    }

    public static ColorType getColorTypeFromDye(DyeColor dyeColor) {
        for (ColorType colorType : ColorType.values()) {
            if (colorType.getDyeColor() == dyeColor) {
                return colorType;
            }
        }
        return ColorType.WHITE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (item instanceof HammerItem || item instanceof WrenchItem) {
            return InteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hit);
        }

        DyeColor dye = stack.getItem() instanceof DyeItem dyeItem ? dyeItem.getDyeColor() : null;
        if (dye != null) {
            ColorType newColorType = getColorTypeFromDye(dye);

            dyeConnectedBlocks(level, pos, newColorType);
            state = state.setValue(COLOR, newColorType);

            if (!player.isCreative()) {
                stack.shrink(1);
            }

            level.setBlock(pos, state, Block.UPDATE_ALL);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            return InteractionResult.SUCCESS;
        } else {
            if (player.getItemInHand(hand).is(ModItemTags.LAMPS) && state.getValue(FACING) == Direction.UP && hit.getDirection() == Direction.UP) {
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.SUCCESS;
    }

    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        state = state.cycle(LIT);
        level.setBlock(pos, state, 3);
        level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 1.0f, 1.0f);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    private void dyeConnectedBlocks(Level level, BlockPos startPos, ColorType color) {
        BlockState startState = level.getBlockState(startPos);
        if (startState.getBlock() instanceof LampBlock && startState.getValue(COLOR) != color) {
            level.setBlock(startPos, startState.setValue(COLOR, color), Block.UPDATE_ALL);
            updateBlockEntityColor(level, startPos, startState.setValue(COLOR, color));

            dyeBlocksInDirection(level, startPos.mutable().move(Direction.UP), Direction.UP, color);
            dyeBlocksInDirection(level, startPos.mutable().move(Direction.DOWN), Direction.DOWN, color);
        }
    }

    private void dyeBlocksInDirection(Level level, BlockPos.MutableBlockPos pos, Direction direction, ColorType color) {
        BlockState state = level.getBlockState(pos);
        while (state.getBlock() instanceof LampBlock && state.getValue(COLOR) != color) {
            level.setBlock(pos, state.setValue(COLOR, color), Block.UPDATE_ALL);
            updateBlockEntityColor(level, pos, state.setValue(COLOR, color));

            pos.move(direction);
            state = level.getBlockState(pos);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, LIT, POWERED, FACING, VERTICAL, COLOR);
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

    public DyeColor getColor() {
        return this.defaultBlockState().getValue(COLOR).getDyeColor();
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new LockableBlockEntity(pos, state);
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

    @Override
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
}