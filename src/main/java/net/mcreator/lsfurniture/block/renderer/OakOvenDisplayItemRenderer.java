package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.OakOvenDisplayItem;

public class OakOvenDisplayItemRenderer extends GeoItemRenderer<OakOvenDisplayItem> {
	public OakOvenDisplayItemRenderer() {
		super(new OakOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(OakOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
