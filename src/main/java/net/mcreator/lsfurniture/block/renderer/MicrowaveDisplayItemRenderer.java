package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MicrowaveDisplayModel;
import net.mcreator.lsfurniture.block.display.MicrowaveDisplayItem;

public class MicrowaveDisplayItemRenderer extends GeoItemRenderer<MicrowaveDisplayItem> {
	public MicrowaveDisplayItemRenderer() {
		super(new MicrowaveDisplayModel());
	}

	@Override
	public RenderType getRenderType(MicrowaveDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
