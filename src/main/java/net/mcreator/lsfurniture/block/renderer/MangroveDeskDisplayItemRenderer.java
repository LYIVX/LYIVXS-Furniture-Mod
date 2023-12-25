package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveDeskDisplayItem;

public class MangroveDeskDisplayItemRenderer extends GeoItemRenderer<MangroveDeskDisplayItem> {
	public MangroveDeskDisplayItemRenderer() {
		super(new MangroveDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveDeskDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
