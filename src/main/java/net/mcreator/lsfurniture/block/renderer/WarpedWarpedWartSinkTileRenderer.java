package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWarpedWartSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedWarpedWartSinkTileEntity;

public class WarpedWarpedWartSinkTileRenderer extends GeoBlockRenderer<WarpedWarpedWartSinkTileEntity> {
	public WarpedWarpedWartSinkTileRenderer() {
		super(new WarpedWarpedWartSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedWarpedWartSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
