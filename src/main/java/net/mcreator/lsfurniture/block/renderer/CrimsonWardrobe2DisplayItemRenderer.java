package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.CrimsonWardrobe2DisplayItem;

public class CrimsonWardrobe2DisplayItemRenderer extends GeoItemRenderer<CrimsonWardrobe2DisplayItem> {
	public CrimsonWardrobe2DisplayItemRenderer() {
		super(new CrimsonWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(CrimsonWardrobe2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
