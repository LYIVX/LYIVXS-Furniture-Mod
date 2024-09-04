package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.common.blocks.CounterCupboardBlock;
import net.lyivx.ls_furniture.common.blocks.DrawerBlock;
import net.lyivx.ls_furniture.common.blocks.MailboxBlock;
import net.lyivx.ls_furniture.common.items.LetterItem;
import net.lyivx.ls_furniture.common.menus.ModChestMenu;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModBlocksTags;
import net.lyivx.ls_furniture.registry.ModItemTags;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

public class MailboxBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> items;
    private ContainerOpenersCounter openersCounter;
    private String owner;
    private String ownerDisplayName;

    public MailboxBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntitys.MAILBOX_ENTITY.get(), blockPos, blockState);
        this.items = NonNullList.withSize(9, ItemStack.EMPTY);
        this.openersCounter = new ContainerOpenersCounter() {
            protected void onOpen(Level level, BlockPos pos, BlockState state) {
                MailboxBlockEntity.this.playSound(state, SoundEvents.BARREL_OPEN);
            }

            protected void onClose(Level level, BlockPos pos, BlockState state) {
                MailboxBlockEntity.this.playSound(state, SoundEvents.BARREL_CLOSE);
            }

            protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int count, int openCount) {
            }

            protected boolean isOwnContainer(Player player) {
                if (player.containerMenu instanceof ModChestMenu) {
                    Container container = ((ModChestMenu)player.containerMenu).getContainer();
                    return container == MailboxBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    public boolean hasMail() {
        for (ItemStack stack : this.items) {
            if (!stack.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void updateDisplayName(Player playerEntity) {
        if(isOwner(playerEntity)) {
            String playerName = playerEntity.getGameProfile().getName();
            if(ownerDisplayName == null || !ownerDisplayName.equals(playerName)) {
                ownerDisplayName = playerName;
                BlockEntityHelper.broadcastUpdate(this, false);
            }
        }
    }

    public void setOwner(Player playerEntity) {
        owner = playerEntity.getStringUUID();
        updateDisplayName(playerEntity);
    }

    public UUID getOwner() {
        return UUID.fromString(owner);
    }

    public boolean hasOwner() {
        return owner != null && !owner.isEmpty();
    }

    public boolean isOwner(Player playerEntity) {
        return hasOwner() && playerEntity.getStringUUID().equals(owner);
    }

    @Override
    protected void setItems(NonNullList<ItemStack> newInventory) {
        items = newInventory;
    }

    public boolean isFull() {
        return !items.contains(ItemStack.EMPTY);
    }

    public ItemStack addMail(ItemStack stack) {
        if(!this.getBlockState().is(ModBlocksTags.BYPASSES_MAIL_TAG_TAG) && !stack.is(ModItemTags.MAIL_TAG)) return stack;
        if(stack.getItem() instanceof LetterItem) LetterItem.signLetter(stack, "Anonymous Player");
        int slot = getFreeSlot();
        if(slot < getContainerSize()) {
            ItemStack result = items.set(slot, stack);
            BlockEntityHelper.broadcastUpdate(this, false);

            if(result.isEmpty()) {
                Player mailboxOwner = level.getPlayerByUUID(getOwner());
                if (mailboxOwner != null) {
                    if (hasCustomName()) {
                        mailboxOwner.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.new_mail_loc", getCustomName()), true);
                    } else {
                        mailboxOwner.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.new_mail"), true);
                    }
                    if(mailboxOwner instanceof ServerPlayer serverPlayer)
                        BlockEntityHelper.playSoundToPlayer(serverPlayer, ModSoundEvents.MAIL_RECEIVED.get(), SoundSource.MASTER, 1.0f, 1.0f);
                }
            }

            return result;
        }
        return stack;
    }

    private int getFreeSlot() {
        int slot = 0;
        while(slot < items.size() && !items.get(slot).isEmpty()) slot++;
        return slot;
    }

    public Component getOwnerDisplayName() {
        return (!hasOwner() || ownerDisplayName.isEmpty()) ? null : Component.literal(ownerDisplayName);
    }

    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.items);
        }
        tag.putString("Owner", owner == null ? "" : owner);
        tag.putString("OwnerDisplayName", ownerDisplayName == null ? "" : ownerDisplayName);
    }

    public void load(CompoundTag tag) {
        super.load(tag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, this.items);
        }
        owner = tag.getString("Owner");
        ownerDisplayName = tag.getString("OwnerDisplayName");
    }

    public int getContainerSize() {
        return 9;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected Component getDefaultName() {
        return Component.translatable("container.ls_furniture.mailbox");
    }

    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return ModChestMenu.oneRows(containerId, inventory, this);
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

    void playSound(BlockState state, SoundEvent sound) {
        Vec3i vec3i = (state.getValue(MailboxBlock.FACING)).getNormal();
        double d = (double)this.worldPosition.getX() + 0.5 + (double)vec3i.getX() / 2.0;
        double e = (double)this.worldPosition.getY() + 0.5 + (double)vec3i.getY() / 2.0;
        double f = (double)this.worldPosition.getZ() + 0.5 + (double)vec3i.getZ() / 2.0;
        this.level.playSound(null, d, e, f, sound, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
    }
}