package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.Darkoakwardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.Darkoakwardrobe2DisplayItem;

public class Darkoakwardrobe2DisplayItemRenderer extends GeoItemRenderer<Darkoakwardrobe2DisplayItem> {
	public Darkoakwardrobe2DisplayItemRenderer() {
		super(new Darkoakwardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(Darkoakwardrobe2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
