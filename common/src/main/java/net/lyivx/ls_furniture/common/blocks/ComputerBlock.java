package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.entity.ToasterBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class ComputerBlock extends Block implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty VARIANT = ModBlockStateProperties.VARIANT;

    protected static final VoxelShape NORTH = Stream.of(
            Block.box(2, 0, 9, 14, 1, 13),
            Block.box(5, 0, 3, 14, 1, 7),
            Block.box(2, 0, 3, 4, 1, 7),
            Block.box(7, 1, 11, 9, 3, 13),
            Block.box(0, 3, 11, 16, 13, 13),
            Block.box(5.05, 1, 3.05, 13.95, 1.1, 6.949999999999999),
            Block.box(2.05, 1, 4.85, 3.9499999999999984, 1.1, 6.949999999999999),
            Block.box(3.1, 0.19999999999999996, 4.9, 3.9000000000000004, 1.1999999999999997, 6.9),
            Block.box(7.1, 0.19999999999999996, 3.1, 7.9, 1.1999999999999997, 3.9),
            Block.box(13.1, 0.19999999999999996, 6.1, 13.9, 1.1999999999999997, 6.9),
            Block.box(12.1, 0.19999999999999996, 6.1, 12.9, 1.1999999999999997, 6.9),
            Block.box(11.1, 0.19999999999999996, 6.1, 11.9, 1.1999999999999997, 6.9),
            Block.box(10.1, 0.19999999999999996, 6.1, 10.9, 1.1999999999999997, 6.9),
            Block.box(9.1, 0.19999999999999996, 6.1, 9.9, 1.1999999999999997, 6.9),
            Block.box(8.1, 0.19999999999999996, 6.1, 8.9, 1.1999999999999997, 6.9),
            Block.box(8.1, 0.19999999999999996, 5.1, 8.9, 1.1999999999999997, 5.9),
            Block.box(7.1, 0.19999999999999996, 5.1, 7.9, 1.1999999999999997, 5.9),
            Block.box(6.1, 0.19999999999999996, 5.1, 6.9, 1.1999999999999997, 5.9),
            Block.box(5.1, 0.19999999999999996, 5.1, 5.9, 1.1999999999999997, 5.9),
            Block.box(5.1, 0.19999999999999996, 6.1, 5.9, 1.1999999999999997, 6.9),
            Block.box(6.1, 0.19999999999999996, 6.1, 6.9, 1.1999999999999997, 6.9),
            Block.box(7.1, 0.19999999999999996, 6.1, 7.9, 1.1999999999999997, 6.9),
            Block.box(8.1, 0.19999999999999996, 4.1, 9.9, 1.1999999999999997, 4.9),
            Block.box(8.1, 0.19999999999999996, 3.0999999999999996, 8.9, 1.1999999999999997, 3.9000000000000004),
            Block.box(9.1, 0.19999999999999996, 3.0999999999999996, 9.9, 1.1999999999999997, 3.9000000000000004),
            Block.box(10.1, 0.19999999999999996, 3.0999999999999996, 12.9, 1.1999999999999997, 3.9000000000000004),
            Block.box(13.1, 0.19999999999999996, 3.0999999999999996, 13.9, 1.1999999999999997, 3.9000000000000004),
            Block.box(13.1, 0.19999999999999996, 4.1, 13.9, 1.1999999999999997, 4.9),
            Block.box(13.1, 0.19999999999999996, 5.1, 13.9, 1.1999999999999997, 5.9),
            Block.box(12.1, 0.19999999999999996, 5.1, 12.9, 1.1999999999999997, 5.9),
            Block.box(11.1, 0.19999999999999996, 5.1, 11.9, 1.1999999999999997, 5.9),
            Block.box(10.1, 0.19999999999999996, 5.1, 10.9, 1.1999999999999997, 5.9),
            Block.box(10.1, 0.19999999999999996, 4.1, 10.9, 1.1999999999999997, 4.9),
            Block.box(11.1, 0.19999999999999996, 4.1, 11.9, 1.1999999999999997, 4.9),
            Block.box(12.1, 0.19999999999999996, 4.1, 12.9, 1.1999999999999997, 4.9),
            Block.box(9.1, 0.19999999999999996, 5.1, 9.9, 1.1999999999999997, 5.9),
            Block.box(6.1, 0.19999999999999996, 3.1, 6.9, 1.1999999999999997, 3.8999999999999995),
            Block.box(5.1, 0.19999999999999996, 3.1, 5.9, 1.1999999999999997, 3.8999999999999995),
            Block.box(6.1, 0.19999999999999996, 4.1, 6.9, 1.1999999999999997, 4.8999999999999995),
            Block.box(2.1, 0.19999999999999996, 4.9, 2.9000000000000004, 1.1999999999999997, 6.9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public ComputerBlock(int defaultBackVariant, Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(VARIANT, defaultBackVariant));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, VARIANT);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    private static final VoxelShape[] SHAPES = new VoxelShape[4];

    static {
        SHAPES[0] = ShapeUtil.rotateShape(NORTH, Direction.SOUTH); //South
        SHAPES[1] = ShapeUtil.rotateShape(NORTH, Direction.WEST); //West
        SHAPES[2] = ShapeUtil.rotateShape(NORTH, Direction.NORTH); //North
        SHAPES[3] = ShapeUtil.rotateShape(NORTH, Direction.EAST); //East
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);

        return SHAPES[direction.get2DDataValue()];
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return InteractionResult.FAIL;
        }

        BlockState onState = state.cycle(VARIANT);
        level.setBlock(pos, onState, 3);

        return InteractionResult.SUCCESS;
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
