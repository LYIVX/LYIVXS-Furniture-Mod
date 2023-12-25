package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveQuartzSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveQuartzSinkDisplayItem;

public class MangroveQuartzSinkDisplayItemRenderer extends GeoItemRenderer<MangroveQuartzSinkDisplayItem> {
	public MangroveQuartzSinkDisplayItemRenderer() {
		super(new MangroveQuartzSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveQuartzSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
