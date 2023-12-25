package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveOvenDisplayItem;

public class MangroveOvenDisplayItemRenderer extends GeoItemRenderer<MangroveOvenDisplayItem> {
	public MangroveOvenDisplayItemRenderer() {
		super(new MangroveOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
