package net.lyivx.ls_furniture.common.utils.forge;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

public class FluidInteractionUtilImpl {

    public static Fluid getFluidFromItemStack(ItemStack stack) {
        if (stack.isEmpty()) {
            return Fluids.EMPTY;
        }

        // Get the IFluidHandlerItem capability from the ItemStack using Forge standard
        LazyOptional<IFluidHandlerItem> fluidHandlerOptional = stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM);

        // Check if the capability is present and then get the fluid
        if (fluidHandlerOptional.isPresent()) {
            IFluidHandlerItem fluidHandler = fluidHandlerOptional.orElseThrow(AssertionError::new); // Should be present due to isPresent check
            // Check the fluid in the first tank (most buckets/standard containers have one tank)
            FluidStack fluidInHandler = fluidHandler.getFluidInTank(0);
            if (!fluidInHandler.isEmpty()) {
                return fluidInHandler.getFluid();
            }
        }

        return Fluids.EMPTY;
    }
} 