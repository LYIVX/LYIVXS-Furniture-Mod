package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.BirchWardrobe2DisplayItem;

public class BirchWardrobe2DisplayItemRenderer extends GeoItemRenderer<BirchWardrobe2DisplayItem> {
	public BirchWardrobe2DisplayItemRenderer() {
		super(new BirchWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchWardrobe2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
