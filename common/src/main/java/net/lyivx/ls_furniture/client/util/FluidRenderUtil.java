package net.lyivx.ls_furniture.client.util;

import dev.architectury.fluid.FluidStack;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

public class FluidRenderUtil {

    @ExpectPlatform
    public static TextureAtlasSprite[] getSprites(Fluid fluid) {
        // This method will be implemented differently on Forge and Fabric
        throw new AssertionError();
    }

    @ExpectPlatform
    public static int getColor(FluidStack fluidStack, @Nullable BlockAndTintGetter level, @Nullable BlockPos pos) {
        // This method will be implemented differently on Forge and Fabric
        throw new AssertionError();
    }

    // Optionally, add a method for alpha if needed, though color often includes it.
    // @ExpectPlatform
    // public static int getAlpha(FluidStack fluidStack, @Nullable BlockAndTintGetter level, @Nullable BlockPos pos) {
    //     throw new AssertionError();
    // }
} 