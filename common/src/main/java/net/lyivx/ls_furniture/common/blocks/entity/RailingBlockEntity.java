package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.blocks.MailboxBlock;
import net.lyivx.ls_furniture.common.items.LetterItem;
import net.lyivx.ls_furniture.common.menus.ModChestMenu;
import net.lyivx.ls_furniture.common.utils.block.BlockEntityHelper;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
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
import net.minecraft.resources.ResourceLocation;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

import static net.lyivx.ls_furniture.common.blocks.MailboxBlock.HAS_MAIL;

public class RailingBlockEntity extends BlockEntity implements ILockable {
    private static final String LOCKED_TAG = "locked";
    private boolean locked = false;

    public RailingBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntitys.RAILING_ENTITY.get(), blockPos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean(LOCKED_TAG, locked);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        locked = tag.getBoolean(LOCKED_TAG);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
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
