package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.blocks.LampBlock;
import net.lyivx.ls_furniture.common.blocks.properties.ColorType;
import net.lyivx.ls_furniture.common.blocks.properties.VerticalConnectionType;
import net.lyivx.ls_furniture.common.utils.block.ILockable;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;
import static net.lyivx.ls_furniture.common.blocks.LampBlock.COLOR;
import static net.lyivx.ls_furniture.common.blocks.LampBlock.VERTICAL;

public class LampBlockEntity extends BlockEntity implements ILockable {
    private static final String LOCKED_TAG = "locked";
    private boolean locked = false;

    private ColorType color;

    public LampBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntitys.LAMP_ENTITY.get(), blockPos, blockState);
        this.color = blockState.getValue(COLOR);
    }

    public boolean hasColor() {
        return color != null;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
        this.setChanged();  // Notify that the block entity has changed
    }

    @NotNull
    public ResourceLocation getModel() {
        if (level == null || getBlockPos() == null) {
            throw new IllegalStateException("Level or BlockPos is not available.");
        }

        BlockState state = level.getBlockState(getBlockPos());

        if (state.getValue(VERTICAL) == VerticalConnectionType.TOP || state.getValue(VERTICAL) == VerticalConnectionType.SINGLE) {
            // Return the model resource location based on the block's color
            return createResourceLocation("block/lamp/shade/" + color.getDyeColor().getName());
        } else {
            // Handle other cases or return a default model if necessary
            return createResourceLocation("block/lamp/shade/default");
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putBoolean(LOCKED_TAG, locked);
        if (color != null) {
            tag.putInt("color", color.getDyeColor().getId());
        }
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        locked = tag.getBoolean(LOCKED_TAG);
        if (tag.contains("color")) {
            DyeColor dyeColor = DyeColor.byId(tag.getInt("color"));
            this.color = ColorType.fromDyeColor(dyeColor); // Ensure ColorType.fromDyeColor() converts DyeColor to ColorType
        } else {
            this.color = ColorType.WHITE;
        }
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