package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedDrawerDisplayItem;

public class WarpedDrawerDisplayItemRenderer extends GeoItemRenderer<WarpedDrawerDisplayItem> {
	public WarpedDrawerDisplayItemRenderer() {
		super(new WarpedDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedDrawerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
