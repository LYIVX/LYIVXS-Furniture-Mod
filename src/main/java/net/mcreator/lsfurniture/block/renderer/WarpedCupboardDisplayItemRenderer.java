package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.WarpedCupboardDisplayItem;

public class WarpedCupboardDisplayItemRenderer extends GeoItemRenderer<WarpedCupboardDisplayItem> {
	public WarpedCupboardDisplayItemRenderer() {
		super(new WarpedCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(WarpedCupboardDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
