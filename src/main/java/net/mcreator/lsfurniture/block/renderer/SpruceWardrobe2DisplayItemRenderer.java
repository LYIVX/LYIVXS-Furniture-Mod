package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceWardrobe2DisplayItem;

public class SpruceWardrobe2DisplayItemRenderer extends GeoItemRenderer<SpruceWardrobe2DisplayItem> {
	public SpruceWardrobe2DisplayItemRenderer() {
		super(new SpruceWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceWardrobe2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
