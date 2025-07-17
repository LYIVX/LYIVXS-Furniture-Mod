package net.lyivx.ls_furniture.common.blocks;

import com.mojang.serialization.MapCodec;
import net.lyivx.ls_furniture.common.blocks.entity.CrateBlockEntity;
import net.lyivx.ls_furniture.common.items.WrenchItem;
import net.lyivx.ls_furniture.common.utils.TooltipHelper;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;

import java.util.ArrayList;
import java.util.List;

public class CrateBlock extends BaseEntityBlock implements WrenchItem.WrenchableBlock {
    public static final MapCodec<CrateBlock> CODEC = simpleCodec(CrateBlock::new);
    public static ArrayList<CrateBlock> ALL_CRATES = new ArrayList<>();
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public CrateBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN, false));
        ALL_CRATES.add(this);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CrateBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);
        TooltipHelper.appendInventoryContent(stack, tooltip);
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
            tooltip.add(Component.translatable("tooltip.ls_furniture.shulkerbox"));
        } else {
            tooltip.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CrateBlockEntity crateBlockEntity) {
            player.openMenu(crateBlockEntity);
            if (level instanceof ServerLevel serverLevel) {
                PiglinAi.angerNearbyPiglins(serverLevel, player, true);
            }
        }
        return InteractionResult.CONSUME;    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();
        if (item instanceof WrenchItem) {
            return InteractionResult.FAIL;
        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);

    }

    // copied from ShulkerBoxBlock
    @Override
    public BlockState playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof CrateBlockEntity crateBlockEntity) {
            if (!level.isClientSide && player.isCreative() && !crateBlockEntity.isEmpty()) {
                ItemStack itemStack = new ItemStack(this);
                itemStack.applyComponents(blockEntity.collectComponents());
                ItemEntity itemEntity = new ItemEntity(level, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, itemStack);
                itemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(itemEntity);
            } else {
                crateBlockEntity.unpackLootTable(player);
            }
        }

        return super.playerWillDestroy(level, blockPos, blockState, player);
    }

    // copied from ShulkerBoxBlock

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        BlockEntity blockEntity = (BlockEntity)params.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof CrateBlockEntity crateBlockEntity) {
            params = params.withDynamicDrop(ShulkerBoxBlock.CONTENTS, (consumer) -> {
                for(int i = 0; i < crateBlockEntity.getContainerSize(); ++i) {
                    consumer.accept(crateBlockEntity.getItem(i));
                }

            });
        }

        return super.getDrops(state, params);
    }

    /*@Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        if(stack.hasCustomHoverName()) {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if(tileEntity instanceof CrateBlockEntity) {
                ((CrateBlockEntity) tileEntity).setCustomName(stack.getHoverName());
            }
        }
    }*/

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean dropBlock) {
        ItemStack itemStack = super.getCloneItemStack(levelReader, blockPos, blockState, dropBlock);
        levelReader.getBlockEntity(blockPos, ModBlockEntitys.CRATE_ENTITY.get()).ifPresent((crate) -> {
            CompoundTag tag = new CompoundTag();
            crate.saveToTag(tag, levelReader.registryAccess());
            itemStack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        });
        return itemStack;
    }

    public List<Property<?>> getWrenchableProperties() {
        return List.of(FACING);
    }
}