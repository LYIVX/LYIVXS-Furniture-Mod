package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.CounterCupboardBlockEntity;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class CounterCupboardBlock extends BaseEntityBlock implements WrenchItem.WrenchableBlock {
    public static final MapCodec<CounterCupboardBlock> CODEC = simpleCodec(CounterCupboardBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    protected static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(0, 0, 1, 1, 14, 16),
            Block.box(15, 0, 1, 16, 14, 16),
            Block.box(1, 0, 1, 15, 1, 16),
            Block.box(1, 13, 1, 15, 14, 16),
            Block.box(1, 1, 2, 15, 13, 16),
            Block.box(8.25, 1.5, 1, 14.5, 12.5, 2),
            Block.box(1.5, 1.5, 1, 7.75, 12.5, 2),
            Block.box(0, 14, 0, 16, 16, 16),
            Block.box(0, 16, 15, 16, 18, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.WEST);

    protected static final VoxelShape SHAPE_NORTH_OPEN = Stream.of(
            Block.box(0, 0, 1, 1, 14, 16),
            Block.box(15, 0, 1, 16, 14, 16),
            Block.box(1, 0, 1, 15, 1, 15),
            Block.box(1, 6.5, 2, 15, 7.5, 15),
            Block.box(1, 12, 2, 15, 13, 15),
            Block.box(1, 1, 2, 15, 2, 15),
            Block.box(0, 14, 0, 16, 16, 16),
            Block.box(0, 16, 15, 16, 18, 16),
            Block.box(1, 0, 14, 15, 14, 16),
            Block.box(14, 2, 2, 15, 6.5, 3),
            Block.box(14, 7.5, 2, 15, 12, 3),
            Block.box(7.5, 2, 2, 8.5, 6.5, 3),
            Block.box(7.5, 7.5, 2, 8.5, 12, 3),
            Block.box(1, 2, 2, 2, 6.5, 3),
            Block.box(1, 7.5, 2, 2, 12, 3),
            Block.box(1, 13, 1, 15, 14, 15),
            Block.box(13.9, 1.5, 0.75, 14.9, 12.5, 1.75),
            Block.box(13.65, 1.5, 0.15000000000000213, 14.65, 12.5, 1.1500000000000021),
            Block.box(13.4, 1.5, -0.44999999999999574, 14.4, 12.5, 0.5500000000000043),
            Block.box(13.15, 1.5, -1.0499999999999936, 14.15, 12.5, -0.049999999999993605),
            Block.box(12.9, 1.5, -1.6499999999999915, 13.9, 12.5, -0.6499999999999915),
            Block.box(12.65, 1.5, -2.2499999999999893, 13.65, 12.5, -1.2499999999999893),
            Block.box(12.4, 1.5, -2.849999999999989, 13.4, 12.5, -1.849999999999989),
            Block.box(12.15, 1.5, -3.449999999999987, 13.15, 12.5, -2.449999999999987),
            Block.box(11.9, 1.5, -4.049999999999985, 12.9, 12.5, -3.0499999999999847),
            Block.box(11.65, 1.5, -4.649999999999983, 12.65, 12.5, -3.6499999999999826),
            Block.box(1, 1.5, 0.75, 2, 12.5, 1.75),
            Block.box(1.5, 1.5, 0.25, 2.5, 12.5, 1.25),
            Block.box(2, 1.5, -0.25, 3, 12.5, 0.75),
            Block.box(2.5, 1.5, -0.75, 3.5, 12.5, 0.25),
            Block.box(3, 1.5, -1.25, 4, 12.5, -0.25),
            Block.box(3.5, 1.5, -1.75, 4.5, 12.5, -0.75),
            Block.box(4, 1.5, -2.25, 5, 12.5, -1.25),
            Block.box(4.5, 1.5, -2.75, 5.5, 12.5, -1.75),
            Block.box(5, 1.5, -3.25, 6, 12.5, -2.25)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.WEST);
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            SHAPE_SOUTH, SHAPE_WEST, SHAPE_NORTH, SHAPE_EAST,
            SHAPE_SOUTH_OPEN, SHAPE_WEST_OPEN, SHAPE_NORTH_OPEN, SHAPE_EAST_OPEN
    };


    public CounterCupboardBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CounterCupboardBlockEntity counterCupboardBlockEntity) {
            player.openMenu(counterCupboardBlockEntity);
            PiglinAi.angerNearbyPiglins(player, true);
        }
        return InteractionResult.CONSUME;    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);

    }

    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.is(newState.getBlock())) return;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof Container) {
            Containers.dropContents(level, pos, (Container)blockEntity);
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CounterCupboardBlockEntity counterCupboardBE) counterCupboardBE.recheckOpen();
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CounterCupboardBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    /*@Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (!stack.hasCustomHoverName()) return;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CounterCupboardBlockEntity counterCupboardBlockEntity) counterCupboardBlockEntity.setCustomName(stack.getHoverName());
    }*/

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int shape = state.getValue(FACING).get2DDataValue();
        if (state.getValue(OPEN)) shape += 4;
        return SHAPES[shape];
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, context, tooltip, flag);
    }

    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }
}