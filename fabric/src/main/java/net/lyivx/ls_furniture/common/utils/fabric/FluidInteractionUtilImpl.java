package net.lyivx.ls_furniture.common.utils.fabric;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class FluidInteractionUtilImpl {

    public static Fluid getFluidFromItemStack(ItemStack stack) {
        if (stack.isEmpty()) {
            return Fluids.EMPTY;
        }

        // Use Fabric's FluidStorage API to find a fluid storage associated with the item
        Storage<FluidVariant> fluidStorage = FluidStorage.ITEM.find(stack, ContainerItemContext.withConstant(stack));

        if (fluidStorage != null) {
            FluidVariant storedVariant = StorageUtil.findStoredResource(fluidStorage, variant -> !variant.isBlank());
            if (storedVariant != null) {
                return storedVariant.getFluid();
            }
        }

        return Fluids.EMPTY;
    }
} 