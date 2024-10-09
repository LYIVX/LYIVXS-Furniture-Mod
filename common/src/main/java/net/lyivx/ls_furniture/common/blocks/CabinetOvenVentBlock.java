package net.lyivx.ls_furniture.common.blocks;

import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
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

public class CabinetOvenVentBlock extends Block implements WrenchItem.WrenchableBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape NORTH = Stream.of(
            Block.box(1, -1, 9, 2, 0, 15.9),
            Block.box(14, -1, 9, 15, 0, 15.9),
            Block.box(2, -1, 15, 14, 0, 15.9),
            Block.box(2, -1, 9, 14, 0, 10),
            Block.box(2, -0.75, 10, 14, 0, 15),
            Block.box(9.5, -0.8249999999999993, 8.9, 10, -0.22499999999999964, 9.2),
            Block.box(8.5, -0.8249999999999993, 8.9, 9, -0.22499999999999964, 9.2),
            Block.box(6, -0.8249999999999993, 8.9, 7.5, -0.22499999999999964, 9.2),
            Block.box(0, -2, 15, 16, 0, 16),
            Block.box(0, 0, 9, 16, 1, 10),
            Block.box(0, 0, 15, 16, 1, 16),
            Block.box(0, 0, 10, 1, 1, 15),
            Block.box(15, 0, 10, 16, 1, 15),
            Block.box(0, 1, 9, 16, 15, 16),
            Block.box(0, 15, 9, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final BooleanProperty ON = BooleanProperty.create("on");

    public CabinetOvenVentBlock(Properties properties) {
        super(properties.lightLevel(state -> state.getValue(ON) ? 15 : 0));
        this.registerDefaultState(this.stateDefinition.any().setValue(ON, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ON, FACING);
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

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(ON, false);
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
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide) return ItemInteractionResult.SUCCESS;

        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return ItemInteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockState newState = state.cycle(ON);
        level.setBlockAndUpdate(pos, newState);
        level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.3F, newState.getValue(ON) ? 0.6F : 0.5F);
        return InteractionResult.SUCCESS;
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
