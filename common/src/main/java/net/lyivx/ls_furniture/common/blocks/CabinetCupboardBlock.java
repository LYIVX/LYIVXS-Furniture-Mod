package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.CabinetCupboardBlockEntity;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
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

public class CabinetCupboardBlock extends BaseEntityBlock implements WrenchItem.WrenchableBlock {
    public static final MapCodec<CabinetCupboardBlock> CODEC = simpleCodec(CabinetCupboardBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    protected static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(0, 0, 9, 16, 2, 16),
            Block.box(0, 14, 9, 16, 16, 16),
            Block.box(0, 2, 10, 16, 14, 16),
            Block.box(0, -2, 15, 16, 0, 16),
            Block.box(0, 2, 9, 1, 14, 10),
            Block.box(15, 2, 9, 16, 14, 10),
            Block.box(8.25, 2.5, 9, 14.5, 13.5, 10),
            Block.box(1.5, 2.5, 9, 7.75, 13.5, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.WEST);

    protected static final VoxelShape SHAPE_NORTH_OPEN = Stream.of(
            Block.box(15, 2, 9, 16, 14, 15),
            Block.box(0, -2, 15, 16, 0, 16),
            Block.box(0, 0, 15, 16, 16, 16),
            Block.box(1, 3, 14, 15, 13, 15),
            Block.box(1, 13, 10, 15, 14, 15),
            Block.box(1, 2, 10, 15, 3, 15),
            Block.box(1, 7, 10, 15, 8, 15),
            Block.box(7.5, 8, 10, 8.5, 13, 11),
            Block.box(7.5, 3, 10, 8.5, 7, 11),
            Block.box(14, 3, 10, 15, 7, 11),
            Block.box(14, 8, 10, 15, 13, 11),
            Block.box(1, 8, 10, 2, 13, 11),
            Block.box(1, 3, 10, 2, 7, 11),
            Block.box(1, 2.5, 8.75, 2, 13.5, 9.75),
            Block.box(1.5, 2.5, 8.25, 2.5, 13.5, 9.25),
            Block.box(2.5, 2.5, 7.25, 3.5, 13.5, 8.25),
            Block.box(2, 2.5, 7.75, 3, 13.5, 8.75),
            Block.box(3.5, 2.5, 6.25, 4.5, 13.5, 7.25),
            Block.box(3, 2.5, 6.75, 4, 13.5, 7.75),
            Block.box(4.5, 2.5, 5.25, 5.5, 13.5, 6.25),
            Block.box(5, 2.5, 4.75, 6, 13.5, 5.75),
            Block.box(13.9, 2.5, 8.75, 14.9, 13.5, 9.75),
            Block.box(13.65, 2.5, 8.150000000000002, 14.65, 13.5, 9.150000000000002),
            Block.box(13.4, 2.5, 7.550000000000004, 14.4, 13.5, 8.550000000000004),
            Block.box(13.15, 2.5, 6.950000000000006, 14.15, 13.5, 7.950000000000006),
            Block.box(12.65, 2.5, 5.750000000000011, 13.65, 13.5, 6.750000000000011),
            Block.box(12.9, 2.5, 6.3500000000000085, 13.9, 13.5, 7.3500000000000085),
            Block.box(12.15, 2.5, 4.550000000000013, 13.15, 13.5, 5.550000000000013),
            Block.box(12.4, 2.5, 5.150000000000011, 13.4, 13.5, 6.150000000000011),
            Block.box(11.65, 2.5, 3.3500000000000147, 12.65, 13.5, 4.350000000000017),
            Block.box(11.9, 2.5, 3.9500000000000153, 12.9, 13.5, 4.950000000000015),
            Block.box(4, 2.5, 5.75, 5, 13.5, 6.75),
            Block.box(0, 14, 9, 16, 16, 15),
            Block.box(0, 0, 9, 16, 2, 15),
            Block.box(0, 2, 9, 1, 14, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.WEST);
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            SHAPE_SOUTH, SHAPE_WEST, SHAPE_NORTH, SHAPE_EAST,
            SHAPE_SOUTH_OPEN, SHAPE_WEST_OPEN, SHAPE_NORTH_OPEN, SHAPE_EAST_OPEN
    };


    public CabinetCupboardBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return InteractionResult.FAIL;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CabinetCupboardBlockEntity cabinetCupboardBlockEntity) {
            player.openMenu(cabinetCupboardBlockEntity);
            PiglinAi.angerNearbyPiglins(player, true);
        }
        return InteractionResult.CONSUME;
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
        if (blockEntity instanceof CabinetCupboardBlockEntity cabinetCupboardBE) cabinetCupboardBE.recheckOpen();
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CabinetCupboardBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (!stack.hasCustomHoverName()) return;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CabinetCupboardBlockEntity cabinetCupboardBlockEntity) cabinetCupboardBlockEntity.setCustomName(stack.getHoverName());
    }

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
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }
}