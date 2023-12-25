package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.OakWardrobe2DisplayItem;

public class OakWardrobe2DisplayItemRenderer extends GeoItemRenderer<OakWardrobe2DisplayItem> {
	public OakWardrobe2DisplayItemRenderer() {
		super(new OakWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(OakWardrobe2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
