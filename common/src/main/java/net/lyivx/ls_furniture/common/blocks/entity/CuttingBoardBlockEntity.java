package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CuttingBoardBlockEntity extends BlockEntity {

    private ItemStack item = ItemStack.EMPTY;
    private final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

    public int randomDegree = 0;

    private int uses = 0;
    private int maxUses = 0;

    public CuttingBoardBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntitys.CUTTING_BOARD_ENTITY.get(), blockPos, blockState);
    }

    public boolean use() {
        if (maxUses == 0) return false;
        uses++;
        if (uses >= maxUses && level != null) {
            Optional<ChoppingBoardRecipe> optionalRecipe = getRecipe(level, new SingleRecipeInput(item));
            if (optionalRecipe.isEmpty()) {
                this.updateMaxUses();
                return false;
            }
            ChoppingBoardRecipe recipe = optionalRecipe.get();
            ItemStack output = recipe.assemble(new SingleRecipeInput(item), level.registryAccess());
            this.item = ItemStack.EMPTY;
            if (level != null) {
                level.addFreshEntity(new ItemEntity(level, getBlockPos().getX() + 0.5, getBlockPos().getY() + 0.5, getBlockPos().getZ() + 0.5, output));
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
            this.updateMaxUses();
        }
        return true;
    }

    private Optional<ChoppingBoardRecipe> getRecipe(Level level, SingleRecipeInput input) {
        return level.getRecipeManager().getRecipes().stream()
                .filter(holder -> holder.value() instanceof ChoppingBoardRecipe)
                .map(holder -> (ChoppingBoardRecipe) holder.value())
                .filter(recipe -> recipe.matches(input, level))
                .findFirst();
    }

    public ItemStack setItem(ItemStack item) {
        this.item = item.copy();
        this.item.setCount(1);
        item.shrink(1);
        if (level != null)
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        this.updateMaxUses();
        return item;
    }

    public ItemStack getAndRemoveItem() {
        var item = this.item;
        this.item = ItemStack.EMPTY;
        if (level != null)
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        return item;
    }

    public void updateMaxUses() {
        if (level == null || this.item.isEmpty()) {
            this.uses = 0;
            this.maxUses = 0;
            return;
        }
        Optional<ChoppingBoardRecipe> optionalRecipe = getRecipe(level, new SingleRecipeInput(item));
        if (optionalRecipe.isEmpty()) {
            this.uses = 0;
            this.maxUses = 0;
            return;
        }
        this.uses = 0;
        this.maxUses = optionalRecipe.get().getUses();
    }

    public ItemStack getItem() {
        return item;
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, this.items, true, registries);
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        ContainerHelper.loadAllItems(tag, this.items, registries);
        updateMaxUses();
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true, registries);
        return compoundtag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}