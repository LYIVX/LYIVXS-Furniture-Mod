package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedCounterDisplayItem;

public class WarpedCounterDisplayItemRenderer extends GeoItemRenderer<WarpedCounterDisplayItem> {
	public WarpedCounterDisplayItemRenderer() {
		super(new WarpedCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
