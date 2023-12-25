package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedSinkDisplayItem;

public class WarpedSinkDisplayItemRenderer extends GeoItemRenderer<WarpedSinkDisplayItem> {
	public WarpedSinkDisplayItemRenderer() {
		super(new WarpedSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
