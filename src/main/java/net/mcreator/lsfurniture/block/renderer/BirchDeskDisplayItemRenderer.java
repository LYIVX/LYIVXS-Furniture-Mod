package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchDeskDisplayItem;

public class BirchDeskDisplayItemRenderer extends GeoItemRenderer<BirchDeskDisplayItem> {
	public BirchDeskDisplayItemRenderer() {
		super(new BirchDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchDeskDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
