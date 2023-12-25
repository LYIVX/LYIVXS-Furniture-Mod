package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.NetherWartOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.NetherWartOvenTileEntity;

public class NetherWartOvenTileRenderer extends GeoBlockRenderer<NetherWartOvenTileEntity> {
	public NetherWartOvenTileRenderer() {
		super(new NetherWartOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(NetherWartOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
