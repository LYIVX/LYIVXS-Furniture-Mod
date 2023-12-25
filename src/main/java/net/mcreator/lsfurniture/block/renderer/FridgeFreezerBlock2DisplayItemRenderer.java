package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.FridgeFreezerBlock2DisplayModel;
import net.mcreator.lsfurniture.block.display.FridgeFreezerBlock2DisplayItem;

public class FridgeFreezerBlock2DisplayItemRenderer extends GeoItemRenderer<FridgeFreezerBlock2DisplayItem> {
	public FridgeFreezerBlock2DisplayItemRenderer() {
		super(new FridgeFreezerBlock2DisplayModel());
	}

	@Override
	public RenderType getRenderType(FridgeFreezerBlock2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
