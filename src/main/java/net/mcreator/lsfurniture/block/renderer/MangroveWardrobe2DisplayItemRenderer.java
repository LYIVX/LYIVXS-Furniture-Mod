package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveWardrobe2DisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveWardrobe2DisplayItem;

public class MangroveWardrobe2DisplayItemRenderer extends GeoItemRenderer<MangroveWardrobe2DisplayItem> {
	public MangroveWardrobe2DisplayItemRenderer() {
		super(new MangroveWardrobe2DisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveWardrobe2DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
