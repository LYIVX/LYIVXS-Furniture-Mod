package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceAndesiteSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceAndesiteSinkDisplayItem;

public class SpruceAndesiteSinkDisplayItemRenderer extends GeoItemRenderer<SpruceAndesiteSinkDisplayItem> {
	public SpruceAndesiteSinkDisplayItemRenderer() {
		super(new SpruceAndesiteSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceAndesiteSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
