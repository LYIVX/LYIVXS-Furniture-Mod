package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceSinkDisplayItem;

public class SpruceSinkDisplayItemRenderer extends GeoItemRenderer<SpruceSinkDisplayItem> {
	public SpruceSinkDisplayItemRenderer() {
		super(new SpruceSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
