package net.lyivx.ls_furniture.client.util.fabric;

import dev.architectury.fluid.FluidStack;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.Nullable;

public class FluidRenderUtilImpl {

    public static TextureAtlasSprite[] getSprites(Fluid fluid) {
        FluidRenderHandler handler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);
        if (handler != null) {
            // We need a FluidState, but the specific state doesn't matter for default sprites.
            // Pass null for view and pos as they might not be available/relevant here.
            return handler.getFluidSprites(null, null, fluid.defaultFluidState());
        }
        // Return default placeholder or handle error if no handler found?
        // For now, returning null, SimpleFluidRenderer checks for this.
        return null;
    }

    public static int getColor(FluidStack fluidStack, @Nullable BlockAndTintGetter level, @Nullable BlockPos pos) {
        Fluid fluid = fluidStack.getFluid();
        FluidRenderHandler handler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);
        if (handler != null && level != null && pos != null) {
            // Get the actual state if possible, otherwise default.
            FluidState fluidState = level.getFluidState(pos);
            if (fluidState.isEmpty() || !fluidState.is(fluid)) {
                 fluidState = fluid.defaultFluidState(); // Fallback to default state
            }
            return handler.getFluidColor(level, pos, fluidState);
        } else if (handler != null) {
             // Fallback if level/pos not available, get default color (might not be biome-tinted)
             return handler.getFluidColor(null, null, fluid.defaultFluidState());
        }
        // Default to white if no handler or context
        return 0xFFFFFFFF;
    }
} 