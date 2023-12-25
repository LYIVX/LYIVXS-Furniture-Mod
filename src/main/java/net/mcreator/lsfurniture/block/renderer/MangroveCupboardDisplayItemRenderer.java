package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveCupboardDisplayItem;

public class MangroveCupboardDisplayItemRenderer extends GeoItemRenderer<MangroveCupboardDisplayItem> {
	public MangroveCupboardDisplayItemRenderer() {
		super(new MangroveCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveCupboardDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
