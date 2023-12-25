package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWartOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedWartOvenDisplayItem;

public class WarpedWartOvenDisplayItemRenderer extends GeoItemRenderer<WarpedWartOvenDisplayItem> {
	public WarpedWartOvenDisplayItemRenderer() {
		super(new WarpedWartOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedWartOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
