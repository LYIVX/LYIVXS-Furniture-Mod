package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchCupboardDisplayItem;

public class BirchCupboardDisplayItemRenderer extends GeoItemRenderer<BirchCupboardDisplayItem> {
	public BirchCupboardDisplayItemRenderer() {
		super(new BirchCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchCupboardDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
