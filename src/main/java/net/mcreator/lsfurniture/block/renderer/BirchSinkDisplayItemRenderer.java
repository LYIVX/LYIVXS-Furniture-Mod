package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchSinkDisplayItem;

public class BirchSinkDisplayItemRenderer extends GeoItemRenderer<BirchSinkDisplayItem> {
	public BirchSinkDisplayItemRenderer() {
		super(new BirchSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
