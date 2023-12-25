package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchCounterDisplayItem;

public class BirchCounterDisplayItemRenderer extends GeoItemRenderer<BirchCounterDisplayItem> {
	public BirchCounterDisplayItemRenderer() {
		super(new BirchCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
