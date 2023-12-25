package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.OakWardrobe1DisplayItem;

public class OakWardrobe1DisplayItemRenderer extends GeoItemRenderer<OakWardrobe1DisplayItem> {
	public OakWardrobe1DisplayItemRenderer() {
		super(new OakWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(OakWardrobe1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
