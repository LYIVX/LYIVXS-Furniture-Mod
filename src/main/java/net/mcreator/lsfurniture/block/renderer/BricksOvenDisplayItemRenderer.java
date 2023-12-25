package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BricksOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.BricksOvenDisplayItem;

public class BricksOvenDisplayItemRenderer extends GeoItemRenderer<BricksOvenDisplayItem> {
	public BricksOvenDisplayItemRenderer() {
		super(new BricksOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(BricksOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
