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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.stream.Stream;

public class CounterSinkBlock extends Block implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty HAS_WATER = ModBlockStateProperties.HAS_WATER;

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
                .setValue(FACING, Direction.NORTH)
                .setValue(HAS_WATER, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        BlockPos waterPos = pos.below().below();
        Block water = level.getBlockState(waterPos).getBlock();
        boolean hasWater = state.getValue(HAS_WATER);


        if (water == Blocks.WATER && !hasWater) {
            level.setBlock(pos, state.setValue(HAS_WATER, true), 3);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.SUCCESS;    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();
        boolean hasWater = state.getValue(HAS_WATER);

        if (item instanceof WrenchItem) {
            return InteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        if (item == Items.BUCKET && hasWater) {
            stack.shrink(1);

            ItemStack waterBucket = Items.WATER_BUCKET.getDefaultInstance();
            if (!(player.getInventory().getFreeSlot() < 1)) {
                player.addItem(waterBucket);
            } else {
                popResource(level, pos.above(), waterBucket);
            }

            level.setBlock(pos, state.setValue(HAS_WATER, false), 3);
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        if (item == Items.WATER_BUCKET && !hasWater) {
            stack.shrink(1);

            ItemStack emptyBucket = Items.BUCKET.getDefaultInstance();
            if (!(player.getInventory().getFreeSlot() < 1)) {
                player.addItem(emptyBucket);

            } else {
                popResource(level, pos.above(), emptyBucket);
            }

            level.setBlock(pos, state.setValue(HAS_WATER, true), 3);
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        return InteractionResult.SUCCESS;
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
        builder.add(FACING, WATERLOGGED,HAS_WATER);
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