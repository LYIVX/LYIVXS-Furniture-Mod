package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaOvenDisplayItem;

public class AcaciaOvenDisplayItemRenderer extends GeoItemRenderer<AcaciaOvenDisplayItem> {
	public AcaciaOvenDisplayItemRenderer() {
		super(new AcaciaOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
