package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.OakCounterDisplayItem;

public class OakCounterDisplayItemRenderer extends GeoItemRenderer<OakCounterDisplayItem> {
	public OakCounterDisplayItemRenderer() {
		super(new OakCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(OakCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
