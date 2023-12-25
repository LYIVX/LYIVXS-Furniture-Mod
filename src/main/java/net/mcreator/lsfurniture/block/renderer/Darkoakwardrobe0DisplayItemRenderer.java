package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.Darkoakwardrobe0DisplayModel;
import net.mcreator.lsfurniture.block.display.Darkoakwardrobe0DisplayItem;

public class Darkoakwardrobe0DisplayItemRenderer extends GeoItemRenderer<Darkoakwardrobe0DisplayItem> {
	public Darkoakwardrobe0DisplayItemRenderer() {
		super(new Darkoakwardrobe0DisplayModel());
	}

	@Override
	public RenderType getRenderType(Darkoakwardrobe0DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
