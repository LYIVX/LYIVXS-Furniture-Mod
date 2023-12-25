package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.NetherBricksOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.NetherBricksOvenTileEntity;

public class NetherBricksOvenTileRenderer extends GeoBlockRenderer<NetherBricksOvenTileEntity> {
	public NetherBricksOvenTileRenderer() {
		super(new NetherBricksOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(NetherBricksOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
