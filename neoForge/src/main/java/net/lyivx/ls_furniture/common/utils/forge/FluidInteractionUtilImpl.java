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

        // Query the NeoForge item‐stack fluid handler capability (null if not present)
        IFluidHandlerItem handler = stack.getCapability(Capabilities.FluidHandler.ITEM, null);
        if (handler != null) {
            // Most containers only have one tank at index 0
            FluidStack fluidInHandler = handler.getFluidInTank(0);
            if (fluidInHandler != null && !fluidInHandler.isEmpty()) {
                return fluidInHandler.getFluid();
            }
        }

        return Fluids.EMPTY;
    }
}
