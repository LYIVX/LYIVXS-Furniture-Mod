package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.LockableBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.DirectionProperty;
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
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TableBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock, HammerItem.HammerableBlock {
    public static final MapCodec<TableBlock> CODEC = simpleCodec(TableBlock::new);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LEG1 = ModBlockStateProperties.NORTH_TABLE;
    public static final BooleanProperty LEG2 = ModBlockStateProperties.EAST_TABLE;
    public static final BooleanProperty LEG3 = ModBlockStateProperties.SOUTH_TABLE;
    public static final BooleanProperty LEG4 = ModBlockStateProperties.WEST_TABLE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty UPDATE = ModBlockStateProperties.UPDATE;

    protected static final VoxelShape TOP = Block.box(0, 15, 0, 16, 16, 16);
    protected static final VoxelShape LEG_1 = Block.box(13, 0, 1, 15, 15, 3);
    protected static final VoxelShape LEG_2 = ShapeUtil.rotateShape(LEG_1, Direction.EAST);
    protected static final VoxelShape LEG_3 = ShapeUtil.rotateShape(LEG_1, Direction.SOUTH);
    protected static final VoxelShape LEG_4 = ShapeUtil.rotateShape(LEG_1, Direction.WEST);
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            TOP,
            Shapes.or(TOP, LEG_1),
            Shapes.or(TOP, LEG_2),
            Shapes.or(TOP, LEG_1, LEG_2),
            Shapes.or(TOP, LEG_3),
            Shapes.or(TOP, LEG_1, LEG_3),
            Shapes.or(TOP, LEG_2, LEG_3),
            Shapes.or(TOP, LEG_1, LEG_2, LEG_3),
            Shapes.or(TOP, LEG_4),
            Shapes.or(TOP, LEG_1, LEG_4),
            Shapes.or(TOP, LEG_2, LEG_4),
            Shapes.or(TOP, LEG_1, LEG_2, LEG_4),
            Shapes.or(TOP, LEG_3, LEG_4),
            Shapes.or(TOP, LEG_1, LEG_3, LEG_4),
            Shapes.or(TOP, LEG_2, LEG_3, LEG_4),
            Shapes.or(TOP, LEG_1, LEG_2, LEG_3, LEG_4)
    };

    public TableBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LEG1, true)
                .setValue(LEG2, true)
                .setValue(LEG3, true)
                .setValue(LEG4, true)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int shape = 0;
        if (state.getValue(LEG1)) shape += 1;
        if (state.getValue(LEG2)) shape += 2;
        if (state.getValue(LEG3)) shape += 4;
        if (state.getValue(LEG4)) shape += 8;
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
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof ILockable lockable && lockable.isLocked()) {
            return state;
        }

        return getConnections(state, (LevelAccessor)level, pos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LEG1, LEG2, LEG3, LEG4, UPDATE, WATERLOGGED);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        boolean leg1 = state.getValue(LEG1);
        boolean leg2 = state.getValue(LEG2);
        boolean leg3 = state.getValue(LEG3);
        boolean leg4 = state.getValue(LEG4);
        return switch(rotation) {
            case NONE -> state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
            case CLOCKWISE_90 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(LEG1, leg4)
                    .setValue(LEG2, leg1)
                    .setValue(LEG3, leg2)
                    .setValue(LEG4, leg3);
            case CLOCKWISE_180 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(LEG1, leg3)
                    .setValue(LEG2, leg4)
                    .setValue(LEG3, leg1).setValue(LEG4, leg2);
            case COUNTERCLOCKWISE_90 -> state
                    .setValue(FACING, rotation.rotate(state.getValue(FACING)))
                    .setValue(LEG1, leg2)
                    .setValue(LEG2, leg3)
                    .setValue(LEG3, leg4)
                    .setValue(LEG4, leg1);
        };
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL; // Critical for visibility
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
        boolean leg1 = (!north && !east) || (north && east && !(validConnection(level.getBlockState(pos.north().east()))));
        boolean leg2 = (!east && !south) || (east && south && !(validConnection(level.getBlockState(pos.south().east()))));
        boolean leg3 = (!south && !west) || (south && west && !(validConnection(level.getBlockState(pos.south().west()))));
        boolean leg4 = (!north && !west) || (north && west && !(validConnection(level.getBlockState(pos.north().west()))));
        boolean update = ((north ? 1 : 0) + (east ? 1 : 0) + (south ? 1 : 0) + (west ? 1 : 0)) % 2 == 0;
        return state.setValue(LEG1, leg1).setValue(LEG2, leg2).setValue(LEG3, leg3).setValue(LEG4, leg4).setValue(UPDATE, update);
    }

    public boolean validConnection(BlockState state) {
        return state.is(ModBlocksTags.TABLES_CONNECTABLE);
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
        return List.of(LEG1, LEG2, LEG3, LEG4);
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