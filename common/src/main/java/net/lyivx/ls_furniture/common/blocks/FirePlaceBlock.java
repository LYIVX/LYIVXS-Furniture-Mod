package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class FirePlaceBlock extends Block implements WrenchItem.WrenchableBlock {
    public static final MapCodec<FirePlaceBlock> CODEC = simpleCodec(FirePlaceBlock::new);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty ON = BooleanProperty.create("on");

    private static final VoxelShape NORTH = Stream.of(
            Block.box(8, -0.01, 10, 18, 2, 15.99),
            Block.box(-2, -0.01, 10, 8, 2, 15.99),
            Block.box(0, 4, 12, 4, 12, 15),
            Block.box(12, 4, 12, 16, 12, 15),
            Block.box(0, 12, 12, 16, 16, 15),
            Block.box(0, 0, 12, 16, 4, 15),
            Block.box(0, 2, 14.99, 16, 16, 15.99),
            Block.box(4, 4, 13, 12, 8, 13),
            Block.box(4, 3.1, 13.1, 12, 4.1, 15.1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape[] SHAPES = new VoxelShape[4];

    static {
        SHAPES[0] = ShapeUtil.rotateShape(NORTH, Direction.SOUTH); //South
        SHAPES[1] = ShapeUtil.rotateShape(NORTH, Direction.WEST); //West
        SHAPES[2] = ShapeUtil.rotateShape(NORTH, Direction.NORTH); //North
        SHAPES[3] = ShapeUtil.rotateShape(NORTH, Direction.EAST); //East
    }

    public FirePlaceBlock(Properties properties) {
        super(properties.lightLevel(state -> state.getValue(ON) ? 15 : 0));
        this.registerDefaultState(this.stateDefinition.any().setValue(ON, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ON, FACING, WATERLOGGED);
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
                .setValue(ON, false)
                .setValue(WATERLOGGED, waterlogged);
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
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return InteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        if (stack.is(Items.FLINT_AND_STEEL) && !state.getValue(ON)) {
            BlockState onState = state.setValue(ON, true);
            level.setBlockAndUpdate(pos, onState);
            level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.3F, onState.getValue(ON) ? 0.6F : 0.5F);

            if (!player.isCreative()) {
                stack.hurtAndBreak(1, player, (handToEquipmentSlot(hand)));
            }
            return InteractionResult.SUCCESS;

        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }
        return InteractionResult.FAIL;
    }

    private static EquipmentSlot handToEquipmentSlot(InteractionHand hand) {
        return hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (state.getValue(ON)) {
            BlockState offState = state.setValue(ON, false);
            level.setBlockAndUpdate(pos, offState);
            level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.3F, offState.getValue(ON) ? 0.6F : 0.5F);
            return InteractionResult.SUCCESS;
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.fire_place"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.fire_place_off"));
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

    @Override
    public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, Orientation orientation, boolean moving) {
        super.neighborChanged(state, level, pos, neighborBlock, orientation, moving);
    }
}
