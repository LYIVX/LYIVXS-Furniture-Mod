package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchGraniteCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.BirchGraniteCounterDisplayItem;

public class BirchGraniteCounterDisplayItemRenderer extends GeoItemRenderer<BirchGraniteCounterDisplayItem> {
	public BirchGraniteCounterDisplayItemRenderer() {
		super(new BirchGraniteCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(BirchGraniteCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
