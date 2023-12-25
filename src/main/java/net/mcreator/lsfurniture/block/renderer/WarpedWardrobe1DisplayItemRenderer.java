package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedWardrobe1DisplayItem;

public class WarpedWardrobe1DisplayItemRenderer extends GeoItemRenderer<WarpedWardrobe1DisplayItem> {
	public WarpedWardrobe1DisplayItemRenderer() {
		super(new WarpedWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedWardrobe1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
