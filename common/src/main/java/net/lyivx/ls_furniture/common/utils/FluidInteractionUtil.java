package net.lyivx.ls_furniture.common.utils;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

public class FluidInteractionUtil {

    /**
     * Attempts to get the primary Fluid contained within an ItemStack,
     * assuming it represents a fluid container like a bucket.
     * Returns Fluids.EMPTY if the stack doesn't represent a recognized
     * fluid container or is empty.
     *
     * @param stack The ItemStack to check.
     * @return The contained Fluid, or Fluids.EMPTY if none.
     */
    @ExpectPlatform
    public static Fluid getFluidFromItemStack(ItemStack stack) {
        // Platform-specific implementation needed
        throw new AssertionError();
    }

    // We can add more interaction helpers here later if needed
} 