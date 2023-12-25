package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaCounterDisplayItem;

public class AcaciaCounterDisplayItemRenderer extends GeoItemRenderer<AcaciaCounterDisplayItem> {
	public AcaciaCounterDisplayItemRenderer() {
		super(new AcaciaCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
