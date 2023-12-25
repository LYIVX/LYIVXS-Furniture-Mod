package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.FridgeFreezerBlock1DisplayModel;
import net.mcreator.lsfurniture.block.display.FridgeFreezerBlock1DisplayItem;

public class FridgeFreezerBlock1DisplayItemRenderer extends GeoItemRenderer<FridgeFreezerBlock1DisplayItem> {
	public FridgeFreezerBlock1DisplayItemRenderer() {
		super(new FridgeFreezerBlock1DisplayModel());
	}

	@Override
	public RenderType getRenderType(FridgeFreezerBlock1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
