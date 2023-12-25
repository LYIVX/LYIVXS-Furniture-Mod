package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedWarpedWartSinkTileEntity;

public class WarpedWarpedWartSinkBlockModel extends GeoModel<WarpedWarpedWartSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWarpedWartSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWarpedWartSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWarpedWartSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_warped_warped_wart.png");
	}
}
