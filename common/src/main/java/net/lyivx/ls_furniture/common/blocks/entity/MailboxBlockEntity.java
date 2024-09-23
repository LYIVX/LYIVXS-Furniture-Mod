package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.common.blocks.MailboxBlock;
import net.lyivx.ls_furniture.common.items.LetterItem;
import net.lyivx.ls_furniture.common.menus.ModChestMenu;
import net.lyivx.ls_furniture.common.utils.block.BlockEntityHelper;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModBlocksTags;
import net.lyivx.ls_furniture.registry.ModItemTags;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
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
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

import static net.lyivx.ls_furniture.common.blocks.MailboxBlock.HAS_MAIL;

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

    void updateBlockState(BlockState state, boolean hasMail) {
        BlockState newState = state.setValue(HAS_MAIL, hasMail);
        if (newState != state) {
            this.level.setBlock(this.getBlockPos(), newState, 3);
        }
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
        this.ownerDisplayName = playerEntity.getGameProfile().getName();
        BlockEntityHelper.broadcastUpdate(this, false);
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

    protected void setItems(NonNullList<ItemStack> itemStacks) {
        items = itemStacks;
    }

    public boolean isFull() {
        return !items.contains(ItemStack.EMPTY);
    }

    public ItemStack addMail(ItemStack stack) {
        if (!this.getBlockState().is(ModBlocksTags.BYPASSES_MAIL_TAG_TAG) && !stack.is(ModItemTags.MAIL_TAG)) return stack;

        if (stack.getItem() instanceof LetterItem) {
            LetterItem.signLetter(stack, "Anonymous Player");
        }

        int slot = getFreeSlot();
        if (slot < getContainerSize()) {
            ItemStack currentStack = items.get(slot);

            if (currentStack.isEmpty()) {
                ItemStack stackToAdd = stack.copy();
                stackToAdd.setCount(1); // Only add one item

                items.set(slot, stackToAdd);

                stack.shrink(1);

                BlockEntityHelper.broadcastUpdate(this, false);
                updateBlockState(this.getBlockState(), hasMail());

                Player mailboxOwner = level.getPlayerByUUID(getOwner());
                if (mailboxOwner != null) {
                    if (hasCustomName()) {
                        mailboxOwner.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.new_mail_loc", getCustomName()), true);
                    } else {
                        mailboxOwner.displayClientMessage(Component.translatable("msg.ls_furniture.mailbox.new_mail"), true);
                    }
                    if (mailboxOwner instanceof ServerPlayer serverPlayer) {
                        BlockEntityHelper.playSoundToPlayer(serverPlayer, ModSoundEvents.MAIL_RECEIVED.get(), SoundSource.MASTER, 1.0f, 1.0f);
                    }
                }

                return stack;
            }

            return stack;
        }

        return stack;
    }


    private int getFreeSlot() {
        int slot = 0;
        while(slot < items.size() && !items.get(slot).isEmpty()) slot++;
        return slot;
    }

    public Component getOwnerDisplayName() {
        return (!hasOwner() || ownerDisplayName == null || ownerDisplayName.isEmpty()) ? null : Component.literal(ownerDisplayName);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("Owner", owner == null ? "" : owner);
        tag.putString("OwnerDisplayName", ownerDisplayName == null ? "" : ownerDisplayName);
        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.items);
        }


    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        owner = tag.getString("Owner");
        ownerDisplayName = tag.getString("OwnerDisplayName");
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, this.items);  // Loading items
        }
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

    public static void tick(Level level, BlockPos pos, BlockState state, MailboxBlockEntity blockEntity) {
        if (!level.isClientSide) {

            MailboxBlockEntity mailboxBlockEntity = (MailboxBlockEntity) blockEntity;
            boolean hasMail = mailboxBlockEntity.hasMail();

            // Only update the block state if the current state differs from the desired state
            if (state.getValue(HAS_MAIL) != hasMail) {
                mailboxBlockEntity.updateBlockState(state, hasMail);

                // Optionally play a sound when the mailbox state changes
                level.playSound(null, pos, ModSoundEvents.MAILBOX_UPDATE.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata(); // Send the current state of the block entity to the client
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
