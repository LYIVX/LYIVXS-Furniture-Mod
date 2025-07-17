package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.blocks.properties.ModBlockStateProperties;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.minecraft.core.BlockPos;
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
            return new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/stool/cushion/tucked/" + color.getName());
        }
        return new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "block/stool/cushion/" + color.getName());
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean(LOCKED_TAG, locked);
        if (color != null) {
            tag.putInt("color", color.getId());
        }
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        locked = tag.getBoolean(LOCKED_TAG);
        color = tag.contains("color") ? DyeColor.byId(tag.getInt("color")) : null;
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
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