package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWarpedWartSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedWarpedWartSinkDisplayItem;

public class WarpedWarpedWartSinkDisplayItemRenderer extends GeoItemRenderer<WarpedWarpedWartSinkDisplayItem> {
	public WarpedWarpedWartSinkDisplayItemRenderer() {
		super(new WarpedWarpedWartSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedWarpedWartSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
