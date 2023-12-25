package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedOvenDisplayItem;

public class WarpedOvenDisplayItemRenderer extends GeoItemRenderer<WarpedOvenDisplayItem> {
	public WarpedOvenDisplayItemRenderer() {
		super(new WarpedOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
