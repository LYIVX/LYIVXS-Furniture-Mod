package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceWardrobe1DisplayItem;

public class SpruceWardrobe1DisplayItemRenderer extends GeoItemRenderer<SpruceWardrobe1DisplayItem> {
	public SpruceWardrobe1DisplayItemRenderer() {
		super(new SpruceWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceWardrobe1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
