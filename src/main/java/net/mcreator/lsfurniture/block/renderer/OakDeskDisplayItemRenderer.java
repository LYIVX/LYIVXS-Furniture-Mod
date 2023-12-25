package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.OakDeskDisplayItem;

public class OakDeskDisplayItemRenderer extends GeoItemRenderer<OakDeskDisplayItem> {
	public OakDeskDisplayItemRenderer() {
		super(new OakDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(OakDeskDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
