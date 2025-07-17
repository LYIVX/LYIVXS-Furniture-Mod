package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.common.blocks.CounterOvenBlock;
import net.lyivx.ls_furniture.common.menus.OvenMenu;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;

public class CounterOvenBlockEntity extends AbstractFurnaceBlockEntity {

    private ContainerOpenersCounter openersCounter;

    public void printSlotContents() {
        System.out.println("Slot 0 (Input): " + this.items.get(0));
        System.out.println("Slot 1 (Fuel): " + this.items.get(1));
        System.out.println("Slot 2 (Result): " + this.items.get(2));
    }

    public CounterOvenBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntitys.COUNTER_OVEN_ENTITY.get(), pos, blockState, RecipeType.SMOKING);
        this.openersCounter = new ContainerOpenersCounter() {
            protected void onOpen(Level level, BlockPos pos, BlockState state) {
                CounterOvenBlockEntity.this.playSound(state, SoundEvents.BARREL_OPEN);
                CounterOvenBlockEntity.this.updateBlockState(state, true);
            }

            protected void onClose(Level level, BlockPos pos, BlockState state) {
                CounterOvenBlockEntity.this.playSound(state, SoundEvents.BARREL_CLOSE);
                CounterOvenBlockEntity.this.updateBlockState(state, false);
            }

            protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int count, int openCount) {
            }

            protected boolean isOwnContainer(Player player) {
                if (player.containerMenu instanceof OvenMenu) {
                    Container container = ((OvenMenu)player.containerMenu).getContainer();
                    return container == CounterOvenBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    protected Component getDefaultName() {
        return Component.translatable("container.ls_furniture.oven");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new OvenMenu(containerId, inventory, this, this.dataAccess, this);
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
        this.level.setBlock(this.getBlockPos(), state.setValue(CounterOvenBlock.OPEN, open), 3);
    }

    void playSound(BlockState state, SoundEvent sound) {
        Direction direction = state.getValue(CounterOvenBlock.FACING);
        double d = (double)this.worldPosition.getX() + 0.5 + (double)direction.getStepX() / 2.0;
        double e = (double)this.worldPosition.getY() + 0.5 + (double)direction.getStepY() / 2.0;
        double f = (double)this.worldPosition.getZ() + 0.5 + (double)direction.getStepZ() / 2.0;
        this.level.playSound(null, d, e, f, sound, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
    }

}