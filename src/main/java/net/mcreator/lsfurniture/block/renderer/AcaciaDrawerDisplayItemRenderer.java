package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaDrawerDisplayItem;

public class AcaciaDrawerDisplayItemRenderer extends GeoItemRenderer<AcaciaDrawerDisplayItem> {
	public AcaciaDrawerDisplayItemRenderer() {
		super(new AcaciaDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaDrawerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
