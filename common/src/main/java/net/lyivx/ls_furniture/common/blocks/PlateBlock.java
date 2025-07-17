package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.PlateBlockEntity;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.lyivx.ls_furniture.common.utils.block.BlockPart;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlateBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<PlateBlock> CODEC = simpleCodec(PlateBlock::new);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 1, 14);

    public PlateBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
        );
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (hitResult.getDirection() != Direction.UP) return InteractionResult.PASS;
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (!(blockentity instanceof PlateBlockEntity plateBE)) return InteractionResult.PASS;

        Direction facing = state.getValue(FACING);
        int slot = BlockPart.get1D(pos, hitResult.getLocation(), facing.getClockWise(),1);

        // Place
        if (!stack.isEmpty()) {
            if (!level.isClientSide && plateBE.placeItem(player.getAbilities().instabuild ? stack.copy() : stack, slot)) {
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            }
            // Avoids client trying to place actual block on top
            return InteractionResult.CONSUME;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (!(blockentity instanceof PlateBlockEntity plateBE)) return InteractionResult.PASS;
        Direction facing = state.getValue(FACING);
        int slot = BlockPart.get1D(pos, hitResult.getLocation(), facing.getClockWise(),1);
        if (plateBE.removeItem(slot, player, level)) return InteractionResult.SUCCESS;
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean dropBlock) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof PlateBlockEntity plateBE) {
            // Get the first non-empty item from the plate
            for (ItemStack stack : plateBE.getItems()) {
                if (!stack.isEmpty()) {
                    return stack.copy();
                }
            }
        }
        // If the plate is empty or there's no valid block entity, return the default behavior
        return super.getCloneItemStack(level, pos, state, dropBlock);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.is(newState.getBlock())) return;

        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof PlateBlockEntity plateBE) Containers.dropContents(level, pos, plateBE.getItems());
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);

        if (direction == Direction.NORTH) {
            return ShapeUtil.rotateShape(SHAPE, Direction.NORTH);
        } else if (direction == Direction.EAST) {
            return ShapeUtil.rotateShape(SHAPE, Direction.EAST);
        } else if (direction == Direction.SOUTH) {
            return ShapeUtil.rotateShape(SHAPE, Direction.SOUTH);
        } else {
            return ShapeUtil.rotateShape(SHAPE, Direction.WEST);
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, waterlogged);
    }


    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PlateBlockEntity(pos, state);
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
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.hammerable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, context, tooltip, flag);
    }
}