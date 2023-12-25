package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceCounterDisplayItem;

public class SpruceCounterDisplayItemRenderer extends GeoItemRenderer<SpruceCounterDisplayItem> {
	public SpruceCounterDisplayItemRenderer() {
		super(new SpruceCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
