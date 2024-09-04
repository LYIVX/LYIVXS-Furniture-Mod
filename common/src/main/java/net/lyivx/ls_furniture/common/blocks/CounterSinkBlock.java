package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class CounterSinkBlock extends Block implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(0, 16, 15, 16, 18, 16),
            Block.box(0, 14, 0, 2, 16, 16),
            Block.box(2, 14, 0, 14, 16, 2),
            Block.box(14, 14, 0, 16, 16, 16),
            Block.box(2, 14, 13, 14, 16, 16),
            Block.box(0, 0, 1, 2, 14, 16),
            Block.box(14, 0, 1, 16, 14, 16),
            Block.box(2, 0, 14, 14, 14, 16),
            Block.box(2, 12, 1, 14, 14, 3),
            Block.box(2, 0, 1, 14, 12, 14),
            Block.box(3, 11, 4, 13, 13, 12),
            Block.box(13, 13, 2, 15, 17, 14),
            Block.box(1, 13, 2, 3, 17, 14),
            Block.box(3, 13, 12, 13, 17, 14),
            Block.box(3, 13, 3, 13, 17, 4),
            Block.box(3, 14, 2, 13, 17, 3),
            Block.box(7, 17, 12, 9, 20, 14),
            Block.box(7, 20, 9, 9, 22, 14),
            Block.box(7.5, 19, 9.5, 8.5, 20, 10.5),
            Block.box(4, 17.4, 11.5, 5, 18.4, 12.5),
            Block.box(4, 17.4, 13.5, 5, 18.4, 14.5),
            Block.box(5, 17.4, 12.5, 6, 18.4, 13.5),
            Block.box(3, 17.4, 12.5, 4, 18.4, 13.5),
            Block.box(4, 17.4, 12.5, 5, 18.4, 13.5),
            Block.box(4, 17, 12.5, 5, 18, 13.5),
            Block.box(11, 17, 12.5, 12, 18, 13.5),
            Block.box(11, 17.4, 13.5, 12, 18.4, 14.5),
            Block.box(12, 17.4, 12.5, 13, 18.4, 13.5),
            Block.box(10, 17.4, 12.5, 11, 18.4, 13.5),
            Block.box(11, 17.4, 12.5, 12, 18.4, 13.5),
            Block.box(11, 17.4, 11.5, 12, 18.4, 12.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SHAPE_EAST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.EAST);
    protected static final VoxelShape SHAPE_SOUTH = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.SOUTH);
    protected static final VoxelShape SHAPE_WEST = ShapeUtil.rotateShape(SHAPE_NORTH, Direction.WEST);

    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            SHAPE_SOUTH, SHAPE_WEST, SHAPE_NORTH, SHAPE_EAST
    };


    public CounterSinkBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int shape = state.getValue(FACING).get2DDataValue();
        return SHAPES[shape];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
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