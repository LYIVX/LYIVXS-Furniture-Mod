package net.lyivx.ls_furniture.common.blocks.entity;

import dev.architectury.injectables.annotations.PlatformOnly;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class DrainerBlockEntity extends BlockEntity implements Clearable, ILockable {
    private static final String LOCKED_TAG = "locked";
    private boolean locked = false;
    private final NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);

    public DrainerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntitys.DRAINER_ENTITY.get(), blockPos, blockState);
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        locked = tag.getBoolean(LOCKED_TAG);
        this.items.clear();
        ContainerHelper.loadAllItems(tag, this.items);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean(LOCKED_TAG, locked);
        ContainerHelper.saveAllItems(tag, this.items, true);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true);
        return compoundtag;
    }

    public boolean placeItem(ItemStack stack, int position) {
        ItemStack itemstack = this.items.get(position);
        if (!itemstack.isEmpty()) return false;

        this.items.set(position, stack.split(stack.getCount()));
        this.markUpdated();
        return true;
    }

    public boolean removeItem(int index, Player player, Level level) {
        if (this.items.get(index).isEmpty()) return false;

        if (level.isClientSide()) {
            player.playSound(SoundEvents.ITEM_PICKUP);
            return true;
        }

        ItemStack item = this.items.get(index).copy();
        player.setItemSlot(EquipmentSlot.MAINHAND, item);
        this.items.set(index, ItemStack.EMPTY);
        this.markUpdated();
        return true;
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public void clearContent() {
        this.items.clear();
    }

    public void removeAllItems() {
        boolean update = false;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).isEmpty()) continue;
            double posX = worldPosition.getX() + 0.3 + 0.4 * (i % 2);
            double posY = worldPosition.getY() + 1.0;
            double posZ = worldPosition.getZ() + 0.3 + 0.4 * (i / 2);

            ItemEntity entity = new ItemEntity(this.level, posX, posY + 0.1, posZ, this.items.get(i).copy());
            this.level.addFreshEntity(entity);
            this.items.set(i, ItemStack.EMPTY);
            update = true;

        }
        if (update) {
            this.markUpdated();
        }
    }

    @PlatformOnly(PlatformOnly.FORGE)
    public AABB getRenderBoundingBox() {
        return new AABB(worldPosition.offset(0, 0, 0).getCenter(), worldPosition.offset(1, 2, 1).getCenter());
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void setLocked(boolean locked) {
        this.locked = locked;
        setChanged();
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }
}