package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.GraniteOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.GraniteOvenDisplayItem;

public class GraniteOvenDisplayItemRenderer extends GeoItemRenderer<GraniteOvenDisplayItem> {
	public GraniteOvenDisplayItemRenderer() {
		super(new GraniteOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(GraniteOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
