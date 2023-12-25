package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWarpedWartCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedWarpedWartCounterTileEntity;

public class WarpedWarpedWartCounterTileRenderer extends GeoBlockRenderer<WarpedWarpedWartCounterTileEntity> {
	public WarpedWarpedWartCounterTileRenderer() {
		super(new WarpedWarpedWartCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedWarpedWartCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
