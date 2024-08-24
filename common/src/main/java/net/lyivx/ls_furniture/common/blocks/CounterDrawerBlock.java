package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.entity.CounterDrawerBlockEntity;
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

public class CounterDrawerBlock extends BaseEntityBlock implements WrenchItem.WrenchableBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    protected static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(0, 16, 15, 16, 18, 16),
            Block.box(0, 14, 0, 16, 16, 16),
            Block.box(0, 0, 1, 1, 14, 16),
            Block.box(15, 0, 1, 16, 14, 16),
            Block.box(1, 0, 1, 15, 1, 3),
            Block.box(1, 13, 1, 15, 14, 3),
            Block.box(1, 0, 3, 15, 1, 14),
            Block.box(1, 13, 3, 15, 14, 14),
            Block.box(1, 0, 14, 15, 14, 16),
            Block.box(1.5, 7.5, 1, 14.5, 12.5, 2),
            Block.box(3, 9, 14, 13, 12, 15),
            Block.box(13, 9, 2, 14, 12, 15),
            Block.box(2, 9, 2, 3, 12, 15),
            Block.box(2, 8, 2, 14, 9, 15),
            Block.box(1.5, 1.5, 1, 14.5, 6.5, 2),
            Block.box(2, 2, 2, 14, 3, 15),
            Block.box(2, 3, 2, 3, 6, 15),
            Block.box(13, 3, 2, 14, 6, 15),
            Block.box(3, 3, 14, 13, 6, 15),
            Block.box(2, 1, 2, 14, 2, 3),
            Block.box(1, 1, 2, 2, 13, 3),
            Block.box(2, 6, 2, 14, 8, 3),
            Block.box(2, 12, 2, 14, 13, 3),
            Block.box(14, 1, 2, 15, 13, 3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.WEST);

    protected static final VoxelShape SHAPE_NORTH_OPEN = Stream.of(
            Block.box(0, 16, 15, 16, 18, 16),
            Block.box(0, 14, 0, 16, 16, 16),
            Block.box(0, 0, 1, 1, 14, 16),
            Block.box(15, 0, 1, 16, 14, 16),
            Block.box(1, 0, 1, 15, 1, 3),
            Block.box(1, 13, 1, 15, 14, 3),
            Block.box(1, 0, 3, 15, 1, 14),
            Block.box(1, 13, 3, 15, 14, 14),
            Block.box(1, 0, 14, 15, 14, 16),
            Block.box(1.5, 7.5, -2, 14.5, 12.5, -1),
            Block.box(3, 9, 11, 13, 12, 12),
            Block.box(13, 9, -1, 14, 12, 12),
            Block.box(2, 9, -1, 3, 12, 12),
            Block.box(2, 8, -1, 14, 9, 12),
            Block.box(1.5, 1.5, -5, 14.5, 6.5, -4),
            Block.box(2, 2, -4, 14, 3, 9),
            Block.box(2, 3, -4, 3, 6, 9),
            Block.box(13, 3, -4, 14, 6, 9),
            Block.box(3, 3, 8, 13, 6, 9),
            Block.box(2, 1, 2, 14, 2, 3),
            Block.box(1, 1, 2, 2, 13, 3),
            Block.box(2, 6, 2, 14, 8, 3),
            Block.box(2, 12, 2, 14, 13, 3),
            Block.box(14, 1, 2, 15, 13, 3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST_OPEN = ShapeUtil.rotateShape(SHAPE_NORTH_OPEN, Direction.WEST);
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            SHAPE_SOUTH, SHAPE_WEST, SHAPE_NORTH, SHAPE_EAST,
            SHAPE_SOUTH_OPEN, SHAPE_WEST_OPEN, SHAPE_NORTH_OPEN, SHAPE_EAST_OPEN
    };


    public CounterDrawerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN, false));
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CounterDrawerBlockEntity counterDrawerBlockEntity) {
            player.openMenu(counterDrawerBlockEntity);
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
        if (blockEntity instanceof CounterDrawerBlockEntity counterDrawerBE) counterDrawerBE.recheckOpen();
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CounterDrawerBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (!stack.hasCustomHoverName()) return;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CounterDrawerBlockEntity counterDrawerBlockEntity) counterDrawerBlockEntity.setCustomName(stack.getHoverName());
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