package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.NetherWartOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.NetherWartOvenDisplayItem;

public class NetherWartOvenDisplayItemRenderer extends GeoItemRenderer<NetherWartOvenDisplayItem> {
	public NetherWartOvenDisplayItemRenderer() {
		super(new NetherWartOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(NetherWartOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
