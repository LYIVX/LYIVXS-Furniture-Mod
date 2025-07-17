package net.lyivx.ls_furniture.common.utils.neoforge;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;

public class FluidInteractionUtilImpl {

    public static Fluid getFluidFromItemStack(ItemStack stack) {
        if (stack.isEmpty()) {
            return Fluids.EMPTY;
        }

        // Get the IFluidHandlerItem capability from the ItemStack
        IFluidHandlerItem fluidHandler = stack.getCapability(Capabilities.FluidHandler.ITEM);

        if (fluidHandler != null) {
            // Check the fluid in the first tank (most buckets/standard containers have one tank)
            FluidStack fluidInHandler = fluidHandler.getFluidInTank(0);
            if (!fluidInHandler.isEmpty()) {
                return fluidInHandler.getFluid();
            }
        }

        return Fluids.EMPTY;
    }
} 