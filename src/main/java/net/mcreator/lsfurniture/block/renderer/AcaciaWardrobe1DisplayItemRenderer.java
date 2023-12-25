package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaWardrobe1DisplayItem;

public class AcaciaWardrobe1DisplayItemRenderer extends GeoItemRenderer<AcaciaWardrobe1DisplayItem> {
	public AcaciaWardrobe1DisplayItemRenderer() {
		super(new AcaciaWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaWardrobe1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
