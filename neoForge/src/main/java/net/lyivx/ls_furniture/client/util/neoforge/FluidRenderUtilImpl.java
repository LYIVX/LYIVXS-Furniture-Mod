package net.lyivx.ls_furniture.client.util.neoforge;

import dev.architectury.fluid.FluidStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import org.jetbrains.annotations.Nullable;

public class FluidRenderUtilImpl {

    public static TextureAtlasSprite[] getSprites(Fluid fluid) {
        IClientFluidTypeExtensions extensions = IClientFluidTypeExtensions.of(fluid);
        ResourceLocation stillTexture = extensions.getStillTexture();
        ResourceLocation flowingTexture = extensions.getFlowingTexture();

        TextureAtlasSprite stillSprite = getSprite(stillTexture);
        TextureAtlasSprite flowingSprite = getSprite(flowingTexture);

        // Ensure we always return something, even if it's the missing sprite
        if (stillSprite == null) stillSprite = getMissingSprite();
        if (flowingSprite == null) flowingSprite = getMissingSprite();

        // SimpleFluidRenderer currently only uses the still sprite (index 0)
        return new TextureAtlasSprite[]{stillSprite, flowingSprite};
    }

    public static int getColor(FluidStack fluidStack, @Nullable BlockAndTintGetter level, @Nullable BlockPos pos) {
        Fluid fluid = fluidStack.getFluid();
        IClientFluidTypeExtensions extensions = IClientFluidTypeExtensions.of(fluid);

        // Determine the correct FluidState to use
        FluidState fluidState;
        if (level != null && pos != null) {
            FluidState stateInWorld = level.getFluidState(pos);
            // Use state in world only if it matches the fluid we're rendering
            if (stateInWorld.is(fluid)) {
                fluidState = stateInWorld;
            } else {
                // If the state in world doesn't match (e.g., different fluid or empty),
                // fall back to the default state of the fluid we *are* rendering.
                fluidState = fluid.defaultFluidState();
            }
        } else {
            // If we don't have world context, use the default state
            fluidState = fluid.defaultFluidState();
        }

        // Pass the FluidState, level, and pos to getTintColor
        return extensions.getTintColor(fluidState, level, pos);
    }

    private static TextureAtlasSprite getSprite(ResourceLocation textureLocation) {
        if (textureLocation == null) {
            return getMissingSprite();
        }
        return Minecraft.getInstance()
                .getTextureAtlas(InventoryMenu.BLOCK_ATLAS)
                .apply(textureLocation);
    }

    private static TextureAtlasSprite getMissingSprite() {
         return Minecraft.getInstance()
                 .getTextureAtlas(InventoryMenu.BLOCK_ATLAS)
                 .apply(ResourceLocation.fromNamespaceAndPath("missingno", "minecraft"));
    }
} 