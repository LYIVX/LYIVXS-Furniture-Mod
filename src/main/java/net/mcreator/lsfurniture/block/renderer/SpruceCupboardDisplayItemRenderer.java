package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceCupboardDisplayItem;

public class SpruceCupboardDisplayItemRenderer extends GeoItemRenderer<SpruceCupboardDisplayItem> {
	public SpruceCupboardDisplayItemRenderer() {
		super(new SpruceCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceCupboardDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
