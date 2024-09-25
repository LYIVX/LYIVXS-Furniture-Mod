package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.lyivx.ls_furniture.common.blocks.entity.TombstoneBlockEntity;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.items.HammerItem;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.ShapeUtil;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
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

public class TombstoneBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, WrenchItem.WrenchableBlock {
    public static final MapCodec<TombstoneBlock> CODEC = simpleCodec(TombstoneBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty HAS_DIRT = ModBlockStateProperties.HAS_DIRT;

    protected static final VoxelShape NORTH = Block.box(2, 0, 12, 14, 16, 14);
    protected static final VoxelShape DIRT_NORTH = Stream.of(
            Block.box(2, 0, 12, 14, 16, 14),
            Block.box(1.75, 0, 3, 14.25, 1, 14.25),
            Block.box(2.75, 0, 14.25, 13.25, 1, 15.25),
            Block.box(3, 0, 2, 13, 1, 3),
            Block.box(4, 1, 8, 12, 2, 14.5),
            Block.box(4, 1, 6, 12, 2, 8)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape[] SHAPE = new VoxelShape[4];
    static {
        SHAPE[0] = ShapeUtil.rotateShape(NORTH, Direction.SOUTH); //South
        SHAPE[1] = ShapeUtil.rotateShape(NORTH, Direction.WEST); //West
        SHAPE[2] = ShapeUtil.rotateShape(NORTH, Direction.NORTH); //North
        SHAPE[3] = ShapeUtil.rotateShape(NORTH, Direction.EAST); //East
    }

    private static final VoxelShape[] DIRT_SHAPE = new VoxelShape[4];
    static {
        DIRT_SHAPE[0] = ShapeUtil.rotateShape(DIRT_NORTH, Direction.SOUTH); //South
        DIRT_SHAPE[1] = ShapeUtil.rotateShape(DIRT_NORTH, Direction.WEST); //West
        DIRT_SHAPE[2] = ShapeUtil.rotateShape(DIRT_NORTH, Direction.NORTH); //North
        DIRT_SHAPE[3] = ShapeUtil.rotateShape(DIRT_NORTH, Direction.EAST); //East
    }

    public TombstoneBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(HAS_DIRT, true));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, HAS_DIRT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean hasDirt = state.getValue(HAS_DIRT);
        if (!hasDirt) {
            return SHAPE[direction.get2DDataValue()];
        } else
            return DIRT_SHAPE[direction.get2DDataValue()];
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (player.isCrouching()) {
            level.setBlock(pos, state.cycle(HAS_DIRT), 3);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return ItemInteractionResult.FAIL;
        }

        if (level.getBlockEntity(pos) instanceof TombstoneBlockEntity tombstoneBlockEntity) {
            if (tombstoneBlockEntity.isOwner(player) || player.isCreative()) {
                if (item instanceof DyeItem && tombstoneBlockEntity.getColor() != ((DyeItem) item).getDyeColor()) {
                    tombstoneBlockEntity.setColor(((DyeItem) item).getDyeColor());
                    level.sendBlockUpdated(pos, state, state, 3);
                    level.playSound((Player)null, tombstoneBlockEntity.getBlockPos(), SoundEvents.DYE_USE, SoundSource.BLOCKS);
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);

                } else if (item == Items.GLOW_INK_SAC && !tombstoneBlockEntity.isGlowing()) {
                    tombstoneBlockEntity.setGlowing(true);
                    level.sendBlockUpdated(pos, state, state, 3);
                    level.playSound((Player)null, tombstoneBlockEntity.getBlockPos(), SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS);
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);

                } else if (item == Items.INK_SAC && tombstoneBlockEntity.isGlowing()) {
                    tombstoneBlockEntity.setGlowing(false);
                    level.sendBlockUpdated(pos, state, state, 3);
                    level.playSound((Player)null, tombstoneBlockEntity.getBlockPos(), SoundEvents.INK_SAC_USE, SoundSource.BLOCKS);
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                }

                if (!level.isClientSide) {
                    // Send a packet to open the screen on the client side
                    LYIVXsFurnitureModClient.openTombstoneGUI(tombstoneBlockEntity);

                }
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof TombstoneBlockEntity tombstoneBlockEntity) {
            if (entity instanceof Player player) {
                tombstoneBlockEntity.setOwner(player);
                player.displayClientMessage(Component.translatable("msg.ls_furniture.tombstone.set_owner"), true);
            }
            tombstoneBlockEntity.setWritten(true);
            tombstoneBlockEntity.setColor(DyeColor.BLACK);
            tombstoneBlockEntity.setChanged();
            level.sendBlockUpdated(pos, state, state, 3);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.tombstone"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, context, tooltip, flag);
    }

    @Override
    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TombstoneBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}