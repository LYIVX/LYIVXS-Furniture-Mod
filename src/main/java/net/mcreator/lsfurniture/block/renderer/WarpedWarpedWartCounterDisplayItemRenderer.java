package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWarpedWartCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedWarpedWartCounterDisplayItem;

public class WarpedWarpedWartCounterDisplayItemRenderer extends GeoItemRenderer<WarpedWarpedWartCounterDisplayItem> {
	public WarpedWarpedWartCounterDisplayItemRenderer() {
		super(new WarpedWarpedWartCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedWarpedWartCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
