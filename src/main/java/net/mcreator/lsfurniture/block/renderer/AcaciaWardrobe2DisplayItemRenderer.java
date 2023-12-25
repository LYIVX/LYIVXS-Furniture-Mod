package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaWardrobe2DisplayItem;

public class AcaciaWardrobe2DisplayItemRenderer extends GeoItemRenderer<AcaciaWardrobe2DisplayItem> {
	public AcaciaWardrobe2DisplayItemRenderer() {
		super(new AcaciaWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaWardrobe2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
