package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakCupboardDisplayModel;
import net.mcreator.lsfurniture.block.display.OakCupboardDisplayItem;

public class OakCupboardDisplayItemRenderer extends GeoItemRenderer<OakCupboardDisplayItem> {
	public OakCupboardDisplayItemRenderer() {
		super(new OakCupboardDisplayModel());
	}

	@Override
	public RenderType getRenderType(OakCupboardDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
