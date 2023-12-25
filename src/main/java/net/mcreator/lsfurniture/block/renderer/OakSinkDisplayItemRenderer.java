package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.OakSinkDisplayItem;

public class OakSinkDisplayItemRenderer extends GeoItemRenderer<OakSinkDisplayItem> {
	public OakSinkDisplayItemRenderer() {
		super(new OakSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(OakSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
