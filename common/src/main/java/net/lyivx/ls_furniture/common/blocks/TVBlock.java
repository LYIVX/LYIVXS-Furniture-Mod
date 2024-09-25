package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
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
import java.util.Objects;
import java.util.stream.Stream;

public class TVBlock extends Block implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty STAND = ModBlockStateProperties.STAND;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty VARIANT = ModBlockStateProperties.VARIANT;

    public TVBlock(int defaultBackVariant, Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(STAND, true)
                .setValue(WATERLOGGED, false)
                .setValue(VARIANT, defaultBackVariant));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, STAND, VARIANT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();
        boolean isStand = clickedFace == Direction.UP;

        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(STAND, isStand);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected static final VoxelShape STAND_VS = Stream.of(
            Block.box(2, 0, 9, 14, 1, 13),
            Block.box(7, 1, 11, 9, 3, 13),
            Block.box(16, 3, 11, 21, 19, 13),
            Block.box(0, 3, 11, 16, 19, 13),
            Block.box(-5, 3, 11, 0, 19, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape WALL_VS = Stream.of(
            Block.box(-5, 0, 13, 0, 16, 15),
            Block.box(0, 0, 13, 16, 16, 15),
            Block.box(16, 0, 13, 21, 16, 15),
            Block.box(12, 6, 15, 13, 10, 16),
            Block.box(3, 6, 15, 4, 10, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape[] WALL_SHAPE = new VoxelShape[4];

    static {
        WALL_SHAPE[0] = ShapeUtil.rotateShape(WALL_VS, Direction.SOUTH); //South
        WALL_SHAPE[1] = ShapeUtil.rotateShape(WALL_VS, Direction.WEST); //West
        WALL_SHAPE[2] = ShapeUtil.rotateShape(WALL_VS, Direction.NORTH); //North
        WALL_SHAPE[3] = ShapeUtil.rotateShape(WALL_VS, Direction.EAST); //East
    }

    private static final VoxelShape[] STAND_SHAPE = new VoxelShape[4];

    static {
        STAND_SHAPE[0] = ShapeUtil.rotateShape(STAND_VS, Direction.SOUTH); //South
        STAND_SHAPE[1] = ShapeUtil.rotateShape(STAND_VS, Direction.WEST); //West
        STAND_SHAPE[2] = ShapeUtil.rotateShape(STAND_VS, Direction.NORTH); //North
        STAND_SHAPE[3] = ShapeUtil.rotateShape(STAND_VS, Direction.EAST); //East
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean isStand = state.getValue(STAND);

        if (!isStand) {
            return WALL_SHAPE[direction.get2DDataValue()];
        } else
            return STAND_SHAPE[direction.get2DDataValue()];
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockState onState = state.cycle(VARIANT);
        level.setBlock(pos, onState, 3);

        if (player != null && Screen.hasShiftDown()) {
            BlockState standState = state.cycle(STAND);
            level.setBlock(pos, standState, 3);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.SUCCESS;    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return ItemInteractionResult.FAIL;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
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
