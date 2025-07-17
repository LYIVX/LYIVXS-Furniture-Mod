package net.lyivx.ls_furniture.common.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

public abstract class LiquidHolderBlockEntity extends BlockEntity {

    // Fluid amounts are typically measured in millibuckets (mB). 1 bucket = 1000 mB.
    public static final int BUCKET_VOLUME = 1000;

    private Fluid fluid = Fluids.EMPTY;
    private int storedAmount = 0;
    private final int capacity; // Capacity in mB

    public LiquidHolderBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int capacity) {
        super(type, pos, state);
        this.capacity = capacity;
    }

    public Fluid getFluid() {
        return fluid;
    }

    // Sets the fluid type and assumes it fills the container to capacity.
    // For partial filling, a more complex method would be needed.
    public void setFluid(Fluid fluid) {
        if (fluid == Fluids.EMPTY) {
            setFluidAndAmount(Fluids.EMPTY, 0);
        } else {
            // Assume setting a fluid type fills it
            setFluidAndAmount(fluid, this.capacity);
        }
    }

    // More precise method to set fluid and amount
    public void setFluidAndAmount(Fluid fluid, int amount) {
        boolean changed = false;
        if (this.fluid != fluid || this.storedAmount != amount) {
            this.fluid = fluid;
            this.storedAmount = Math.min(amount, this.capacity); // Ensure amount doesn't exceed capacity
            if (this.storedAmount <= 0) { // If amount is zero or less, treat as empty
                this.fluid = Fluids.EMPTY;
                this.storedAmount = 0;
            }
            changed = true;
        }

        if (changed) {
            setChanged(); // Mark dirty for saving
            if (level != null && !level.isClientSide) {
                // Send update to client
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            }
        }
    }

    public int getStoredAmount() {
        return storedAmount;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return this.fluid == Fluids.EMPTY || this.storedAmount <= 0;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!isEmpty()) {
            ResourceLocation fluidId = BuiltInRegistries.FLUID.getKey(this.fluid);
            if (fluidId != null) {
                tag.putString("FluidName", fluidId.toString());
                tag.putInt("Amount", this.storedAmount);
            }
        } else {
            // Still save FluidName as empty to distinguish from cases where the tag might be missing
            tag.putString("FluidName", "minecraft:empty");
            tag.putInt("Amount", 0);
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("FluidName")) {
            String fluidName = tag.getString("FluidName");
            if (fluidName.equals("minecraft:empty")) {
                this.fluid = Fluids.EMPTY;
                this.storedAmount = 0;
            } else {
                this.fluid = BuiltInRegistries.FLUID.get(ResourceLocation.parse(fluidName));
                // Load amount, default to capacity if Amount tag is missing (for backwards compatibility?)
                this.storedAmount = tag.getInt("Amount");
                if (this.storedAmount <= 0) { // Ensure consistency if loaded amount is invalid
                    this.fluid = Fluids.EMPTY;
                    this.storedAmount = 0;
                } else {
                     this.storedAmount = Math.min(this.storedAmount, this.capacity); // Clamp to capacity
                }
            }
        } else {
            // Handle legacy or missing tag case
            this.fluid = Fluids.EMPTY;
            this.storedAmount = 0;
        }
    }

    // Required for client sync
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        // Write the data needed to update the client state
        return saveWithoutMetadata(registries);
    }
} 