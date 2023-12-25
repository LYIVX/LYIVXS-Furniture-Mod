package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.Darkoakwardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.Darkoakwardrobe1DisplayItem;

public class Darkoakwardrobe1DisplayItemRenderer extends GeoItemRenderer<Darkoakwardrobe1DisplayItem> {
	public Darkoakwardrobe1DisplayItemRenderer() {
		super(new Darkoakwardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(Darkoakwardrobe1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
