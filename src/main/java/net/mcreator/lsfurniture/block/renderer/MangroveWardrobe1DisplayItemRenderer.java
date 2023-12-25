package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveWardrobe1DisplayItem;

public class MangroveWardrobe1DisplayItemRenderer extends GeoItemRenderer<MangroveWardrobe1DisplayItem> {
	public MangroveWardrobe1DisplayItemRenderer() {
		super(new MangroveWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveWardrobe1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
