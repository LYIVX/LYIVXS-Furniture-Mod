package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakBricksCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.OakBricksCounterDisplayItem;

public class OakBricksCounterDisplayItemRenderer extends GeoItemRenderer<OakBricksCounterDisplayItem> {
	public OakBricksCounterDisplayItemRenderer() {
		super(new OakBricksCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(OakBricksCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
