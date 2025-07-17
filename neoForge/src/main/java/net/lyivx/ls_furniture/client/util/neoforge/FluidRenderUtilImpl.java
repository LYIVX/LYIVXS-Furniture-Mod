package net.lyivx.ls_furniture.client.util.neoforge;

import dev.architectury.fluid.FluidStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlas;
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

        // Get the actual atlas object using the TextureManager
        TextureAtlas blockAtlas = (TextureAtlas) Minecraft.getInstance().getTextureManager().getTexture(InventoryMenu.BLOCK_ATLAS);

        TextureAtlasSprite stillSprite = stillTexture != null ? blockAtlas.getSprite(stillTexture) : null;
        TextureAtlasSprite flowingSprite = flowingTexture != null ? blockAtlas.getSprite(flowingTexture) : null;

        if (stillSprite == null && flowingSprite == null) {
            return null;
        }

        return new TextureAtlasSprite[]{stillSprite, flowingSprite};
    }

    public static int getColor(FluidStack fluidStack, @Nullable BlockAndTintGetter level, @Nullable BlockPos pos) {
        IClientFluidTypeExtensions extensions = IClientFluidTypeExtensions.of(fluidStack.getFluid());

        FluidState fluidState = null;
        if (level != null && pos != null) {
            FluidState stateInWorld = level.getFluidState(pos);
            if (stateInWorld.is(fluidStack.getFluid())) {
                fluidState = stateInWorld;
            }
        }
        if (fluidState == null) {
            fluidState = fluidStack.getFluid().defaultFluidState();
        }

        int color = extensions.getTintColor(fluidState, level, pos);

        return color != -1 ? color : 0xFFFFFFFF;
    }
} 