package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakBricksSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.OakBricksSinkDisplayItem;

public class OakBricksSinkDisplayItemRenderer extends GeoItemRenderer<OakBricksSinkDisplayItem> {
	public OakBricksSinkDisplayItemRenderer() {
		super(new OakBricksSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(OakBricksSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
