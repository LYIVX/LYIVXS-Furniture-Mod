package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveQuartzCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveQuartzCounterDisplayItem;

public class MangroveQuartzCounterDisplayItemRenderer extends GeoItemRenderer<MangroveQuartzCounterDisplayItem> {
	public MangroveQuartzCounterDisplayItemRenderer() {
		super(new MangroveQuartzCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveQuartzCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
