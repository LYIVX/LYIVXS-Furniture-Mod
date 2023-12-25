package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.QuartzOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.QuartzOvenDisplayItem;

public class QuartzOvenDisplayItemRenderer extends GeoItemRenderer<QuartzOvenDisplayItem> {
	public QuartzOvenDisplayItemRenderer() {
		super(new QuartzOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(QuartzOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
