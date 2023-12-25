package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchOvenDisplayItem;

public class BirchOvenDisplayItemRenderer extends GeoItemRenderer<BirchOvenDisplayItem> {
	public BirchOvenDisplayItemRenderer() {
		super(new BirchOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
