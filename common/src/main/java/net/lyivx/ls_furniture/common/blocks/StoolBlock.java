package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_core.common.utils.WoolHelper;
import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ColorType;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.lyivx.ls_furniture.common.utils.block.TuckableBlock;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class StoolBlock extends SeatBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock, TuckableBlock, EntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<ColorType> COLOR = ModBlockStateProperties.COLOR;

    protected static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(3, 0, 3, 5, 9, 5),
            Block.box(3, 0, 11, 5, 9, 13),
            Block.box(11, 0, 11, 13, 9, 13),
            Block.box(11, 0, 3, 13, 9, 5),
            Block.box(3, 9, 3, 13, 11, 13),
            Block.box(5, 5, 3, 11, 7, 5),
            Block.box(5, 5, 11, 11, 7, 13),
            Block.box(3, 5, 5, 5, 7, 11),
            Block.box(11, 5, 5, 13, 7, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.WEST);

    protected static final VoxelShape SHAPE_NORTH_TUCKED = Stream.of(
            Block.box(3, 0, -6, 5, 9, -4),
            Block.box(3, 0, 2, 5, 9, 4),
            Block.box(11, 0, 2, 13, 9, 4),
            Block.box(11, 0, -6, 13, 9, -4),
            Block.box(3, 9, -6, 13, 11, 4),
            Block.box(5, 5, -6, 11, 7, -4),
            Block.box(5, 5, 2, 11, 7, 4),
            Block.box(3, 5, -4, 5, 7, 2),
            Block.box(11, 5, -4, 13, 7, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST_TUCKED = ShapeUtil.rotateShape(SHAPE_NORTH_TUCKED, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH_TUCKED = ShapeUtil.rotateShape(SHAPE_NORTH_TUCKED, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST_TUCKED = ShapeUtil.rotateShape(SHAPE_NORTH_TUCKED, Direction.WEST);
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            SHAPE_SOUTH, SHAPE_WEST, SHAPE_NORTH, SHAPE_EAST,
            SHAPE_SOUTH_TUCKED, SHAPE_WEST_TUCKED, SHAPE_NORTH_TUCKED, SHAPE_EAST_TUCKED
    };

    public StoolBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(TUCKED, false)
                .setValue(COLOR, ColorType.DEFAULT));
    }

    @Override
    public float seatHeight(BlockState state) {
        return 0.45F;
    }

    @Override
    public boolean isSittable(BlockState state) {
        return !state.getValue(TUCKED);
    }

    @Override
    public BlockPos primaryDismountLocation(Level level, BlockState state, BlockPos pos) {
        return pos.relative(state.getValue(FACING));
    }

    @Override
    public float setRiderRotation(BlockState state, Entity entity) {
        return state.getValue(FACING).toYRot();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int shape = state.getValue(FACING).get2DDataValue();
        if (state.getValue(TUCKED)) shape += 4;
        return SHAPES[shape];
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

        if (state.getValue(TUCKED) && level instanceof Level level1) {
            if (!TuckableBlock.canTuckUnderBlockInfront(state, level1, currentPos)) {
                return state.setValue(TUCKED, false);
            }
        }
        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
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
        }

        DyeColor woolDye = WoolHelper.getDyeColor(stack.getItem());
        if (woolDye != null && (state.getValue(COLOR) == ColorType.DEFAULT)) {
            ColorType newColorType = getColorTypeFromDye(woolDye);

            state = state.setValue(COLOR, newColorType);

            if (!player.isCreative()) {
                stack.shrink(1);
            }

            level.setBlock(pos, state, Block.UPDATE_ALL);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            return InteractionResult.SUCCESS;
        }

        DyeColor dye = stack.getItem() instanceof DyeItem dyeItem ? dyeItem.getDyeColor() : null;
        if (dye != null && (state.getValue(COLOR) != ColorType.DEFAULT)) {
            ColorType newColorType = getColorTypeFromDye(dye);

            state = state.setValue(COLOR, newColorType);

            if (!player.isCreative()) {
                stack.shrink(1);
            }

            level.setBlock(pos, state, Block.UPDATE_ALL);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            return InteractionResult.SUCCESS;
        }

        if (stack.is(ModItems.SHEARS.get()) && (state.getValue(COLOR) != ColorType.DEFAULT)) {
            dropCushion(state, level, pos);
            state = state.setValue(COLOR, ColorType.DEFAULT);

            level.setBlock(pos, state, Block.UPDATE_ALL);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            return InteractionResult.SUCCESS;
        }

        if (TuckableBlock.tryTuck(state, level, pos, player)) return InteractionResult.SUCCESS;
        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TUCKED, WATERLOGGED, COLOR);
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
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.dyeable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.lockable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.hammerable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new LockableBlockEntity(pos, state);
    }

    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean moving) {
        if (!state.is(newState.getBlock())) {
            dropCushion(state, level, pos);
        }
        super.onRemove(state, level, pos, newState, moving);
    }

    public void dropCushion(BlockState state, Level level, BlockPos pos) {
        if (state.hasProperty(COLOR) && state.getValue(COLOR) != ColorType.DEFAULT) {
            Block block = WoolHelper.getBlock(state.getValue(COLOR).getDyeColor());
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(block != null ? block : Blocks.WHITE_WOOL));
        }
    }

    public List<Property<?>> getHammerableProperties() {
        return List.of(TUCKED);
    }

    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }

    @Override
    public BlockState updateAfterCycle(BlockState state, LevelAccessor level, BlockPos pos) {
        return WrenchItem.WrenchableBlock.super.updateAfterCycle(state, level, pos);
    }
}