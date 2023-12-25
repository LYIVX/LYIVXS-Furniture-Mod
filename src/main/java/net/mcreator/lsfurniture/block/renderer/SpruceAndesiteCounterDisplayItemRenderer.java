package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceAndesiteCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceAndesiteCounterDisplayItem;

public class SpruceAndesiteCounterDisplayItemRenderer extends GeoItemRenderer<SpruceAndesiteCounterDisplayItem> {
	public SpruceAndesiteCounterDisplayItemRenderer() {
		super(new SpruceAndesiteCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceAndesiteCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
