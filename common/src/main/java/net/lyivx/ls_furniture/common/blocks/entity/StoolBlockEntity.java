package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class StoolBlockEntity extends BlockEntity implements ILockable {
    private static final String LOCKED_TAG = "locked";
    private boolean locked = false;

    @Nullable
    private DyeColor color = null;

    BooleanProperty TUCKED = ModBlockStateProperties.TUCKED;

    public StoolBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntitys.STOOL_ENTITY.get(), blockPos, blockState);
    }

    public boolean hasColor() {
        return color != null;
    }

    public @Nullable DyeColor getColor() {
        return color;
    }

    public void setColor(@Nullable DyeColor color) {
        this.color = color;
    }

    /**
     * @throws NullPointerException if the color is null
     */
    @NotNull
    public ResourceLocation getModel() {
        Boolean tucked = this.getBlockState().getValue(TUCKED);
        Objects.requireNonNull(color);
        if (tucked) {
            return createResourceLocation("block/stool/cushion/tucked/" + color.getName());
        }
        return createResourceLocation("block/stool/cushion/" + color.getName());
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putBoolean(LOCKED_TAG, locked);
        if (color != null) {
            tag.putInt("color", color.getId());
        }
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        locked = tag.getBoolean(LOCKED_TAG);
        color = tag.contains("color") ? DyeColor.byId(tag.getInt("color")) : null;
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        saveAdditional(tag, registries);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
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