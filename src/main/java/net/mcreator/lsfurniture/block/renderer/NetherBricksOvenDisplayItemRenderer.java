package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.NetherBricksOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.NetherBricksOvenDisplayItem;

public class NetherBricksOvenDisplayItemRenderer extends GeoItemRenderer<NetherBricksOvenDisplayItem> {
	public NetherBricksOvenDisplayItemRenderer() {
		super(new NetherBricksOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(NetherBricksOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
