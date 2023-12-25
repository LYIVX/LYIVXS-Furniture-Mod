package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedWardrobe2DisplayItem;

public class WarpedWardrobe2DisplayItemRenderer extends GeoItemRenderer<WarpedWardrobe2DisplayItem> {
	public WarpedWardrobe2DisplayItemRenderer() {
		super(new WarpedWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedWardrobe2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
