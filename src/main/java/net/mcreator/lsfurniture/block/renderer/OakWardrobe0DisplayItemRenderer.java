package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakWardrobe0DisplayModel;
import net.mcreator.lsfurniture.block.display.OakWardrobe0DisplayItem;

public class OakWardrobe0DisplayItemRenderer extends GeoItemRenderer<OakWardrobe0DisplayItem> {
	public OakWardrobe0DisplayItemRenderer() {
		super(new OakWardrobe0DisplayModel());
	}

	@Override
	public RenderType getRenderType(OakWardrobe0DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
