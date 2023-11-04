package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedWarpedWartSinkTileEntity;

public class WarpedWarpedWartSinkBlockModel extends AnimatedGeoModel<WarpedWarpedWartSinkTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_warped_warped_wart.png");
	}
}
