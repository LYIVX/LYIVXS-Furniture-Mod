package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchGraniteSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchGraniteSinkDisplayItem;

public class BirchGraniteSinkDisplayItemRenderer extends GeoItemRenderer<BirchGraniteSinkDisplayItem> {
	public BirchGraniteSinkDisplayItemRenderer() {
		super(new BirchGraniteSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchGraniteSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
