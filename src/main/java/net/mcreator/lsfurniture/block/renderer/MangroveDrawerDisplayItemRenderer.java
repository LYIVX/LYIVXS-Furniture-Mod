package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveDrawerDisplayItem;

public class MangroveDrawerDisplayItemRenderer extends GeoItemRenderer<MangroveDrawerDisplayItem> {
	public MangroveDrawerDisplayItemRenderer() {
		super(new MangroveDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveDrawerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
