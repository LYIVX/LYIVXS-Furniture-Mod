package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.common.utils.block.BlockEntityHelper;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

public class TombstoneBlockEntity extends BlockEntity {
    private String[] lines = new String[]{"", "", "", ""};
    private float[] textSizes = new float[]{1.0f, 1.0f, 1.0f, 1.0f}; // Default size for each line
    private DyeColor color = DyeColor.BLACK;
    private boolean glowing = false;
    private boolean editable = true;
    private boolean isWritten = true; // New field to indicate if the tombstone has been written
    private String owner;
    private String ownerDisplayName;


    public TombstoneBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntitys.TOMBSTONE_ENTITY.get(), pos, state);
    }

    public String[] getLines() {
        return lines;
    }

    public DyeColor getColor() {
        return color;
    }

    public void setColor(DyeColor newColor) {
        this.color = newColor;
        setChanged();
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    public boolean isGlowing() {
        return glowing;
    }

    public void setGlowing(boolean glowing) {
        this.glowing = glowing;
        setChanged();
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        setChanged();
    }

    public void setWritten(boolean written) {
        isWritten = written;
        setChanged();
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    public boolean isWritten() {
        return isWritten;
    }

    public void setLines(String[] newLines) {
        System.arraycopy(newLines, 0, lines, 0, Math.min(newLines.length, 4));
        setChanged();
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    public float[] getTextSizes() {
        return textSizes;
    }

    public void setTextSize(int lineIndex, float size) {
        if (lineIndex >= 0 && lineIndex < 4) {
            textSizes[lineIndex] = size;
            setChanged();
            if (level != null && !level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
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

    public Component getOwnerDisplayName() {
        return (!hasOwner() || ownerDisplayName == null || ownerDisplayName.isEmpty()) ? null : Component.literal(ownerDisplayName);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("Owner", owner == null ? "" : owner);
        for (int i = 0; i < 4; i++) {
            tag.putString("Line" + (i + 1), lines[i]);
            tag.putFloat("TextSize" + (i + 1), textSizes[i]);
        }
        tag.putInt("Color", color.getId());
        tag.putBoolean("Glowing", glowing);
        tag.putBoolean("Editable", editable);
        tag.putBoolean("Written", isWritten);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        owner = tag.getString("Owner");
        for (int i = 0; i < 4; i++) {
            lines[i] = tag.getString("Line" + (i + 1));
            textSizes[i] = tag.getFloat("TextSize" + (i + 1));
        }
        color = DyeColor.byId(tag.getInt("Color"));
        glowing = tag.getBoolean("Glowing");
        editable = tag.getBoolean("Editable");
        isWritten = tag.getBoolean("Written");
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
}