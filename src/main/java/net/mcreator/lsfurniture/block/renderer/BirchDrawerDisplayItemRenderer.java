package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchDrawerDisplayItem;

public class BirchDrawerDisplayItemRenderer extends GeoItemRenderer<BirchDrawerDisplayItem> {
	public BirchDrawerDisplayItemRenderer() {
		super(new BirchDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchDrawerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
