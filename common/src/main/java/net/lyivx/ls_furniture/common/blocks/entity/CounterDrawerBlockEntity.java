package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.common.blocks.CounterCupboardBlock;
import net.lyivx.ls_furniture.common.blocks.CounterDrawerBlock;
import net.lyivx.ls_furniture.common.menus.ModChestMenu;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CounterDrawerBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> items;
    private ContainerOpenersCounter openersCounter;

    public CounterDrawerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntitys.COUNTER_DRAWER_ENTITY.get(), blockPos, blockState);
        this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        this.openersCounter = new ContainerOpenersCounter() {
            protected void onOpen(Level level, BlockPos pos, BlockState state) {
                CounterDrawerBlockEntity.this.playSound(state, ModSoundEvents.DRAWER_OPEN.get());
                CounterDrawerBlockEntity.this.updateBlockState(state, true);
            }

            protected void onClose(Level level, BlockPos pos, BlockState state) {
                CounterDrawerBlockEntity.this.playSound(state, ModSoundEvents.DRAWER_CLOSE.get());
                CounterDrawerBlockEntity.this.updateBlockState(state, false);
            }

            protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int count, int openCount) {
            }

            protected boolean isOwnContainer(Player player) {
                if (player.containerMenu instanceof ModChestMenu) {
                    Container container = ((ModChestMenu)player.containerMenu).getContainer();
                    return container == CounterDrawerBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.items, registries);
        }
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, this.items, registries);
        }
    }

    public int getContainerSize() {
        return 27;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void setItems(NonNullList<ItemStack> itemStacks) {
        this.items = itemStacks;
    }

    protected Component getDefaultName() {
        return Component.translatable("container.ls_furniture.counter_drawer");
    }

    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return ModChestMenu.threeRows(containerId, inventory, this);
    }

    public void startOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void stopOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    void updateBlockState(BlockState state, boolean open) {
        this.level.setBlock(this.getBlockPos(), state.setValue(CounterDrawerBlock.OPEN, open), 3);
    }

    void playSound(BlockState state, SoundEvent sound) {
        Direction direction = state.getValue(CounterDrawerBlock.FACING);
        double d = (double)this.worldPosition.getX() + 0.5 + (double)direction.getStepX() / 2.0;
        double e = (double)this.worldPosition.getY() + 0.5 + (double)direction.getStepY() / 2.0;
        double f = (double)this.worldPosition.getZ() + 0.5 + (double)direction.getStepZ() / 2.0;
        this.level.playSound(null, d, e, f, sound, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
    }
}