package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.MangroveSinkDisplayItem;

public class MangroveSinkDisplayItemRenderer extends GeoItemRenderer<MangroveSinkDisplayItem> {
	public MangroveSinkDisplayItemRenderer() {
		super(new MangroveSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(MangroveSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
