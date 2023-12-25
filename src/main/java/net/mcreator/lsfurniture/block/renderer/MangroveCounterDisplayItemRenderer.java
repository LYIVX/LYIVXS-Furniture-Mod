package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveCounterDisplayItem;

public class MangroveCounterDisplayItemRenderer extends GeoItemRenderer<MangroveCounterDisplayItem> {
	public MangroveCounterDisplayItemRenderer() {
		super(new MangroveCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
