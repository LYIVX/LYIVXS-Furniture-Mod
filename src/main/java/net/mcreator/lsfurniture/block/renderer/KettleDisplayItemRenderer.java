package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.KettleDisplayModel;
import net.mcreator.lsfurniture.block.display.KettleDisplayItem;

public class KettleDisplayItemRenderer extends GeoItemRenderer<KettleDisplayItem> {
	public KettleDisplayItemRenderer() {
		super(new KettleDisplayModel());
	}

	@Override
	public RenderType getRenderType(KettleDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
