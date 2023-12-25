package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedDeskDisplayItem;

public class WarpedDeskDisplayItemRenderer extends GeoItemRenderer<WarpedDeskDisplayItem> {
	public WarpedDeskDisplayItemRenderer() {
		super(new WarpedDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedDeskDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
