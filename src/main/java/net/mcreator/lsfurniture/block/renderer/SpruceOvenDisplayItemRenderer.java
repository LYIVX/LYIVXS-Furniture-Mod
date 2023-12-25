package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceOvenDisplayItem;

public class SpruceOvenDisplayItemRenderer extends GeoItemRenderer<SpruceOvenDisplayItem> {
	public SpruceOvenDisplayItemRenderer() {
		super(new SpruceOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
