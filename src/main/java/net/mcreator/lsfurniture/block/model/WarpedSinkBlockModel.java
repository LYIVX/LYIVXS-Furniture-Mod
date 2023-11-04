package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedSinkTileEntity;

public class WarpedSinkBlockModel extends AnimatedGeoModel<WarpedSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_warped.png");
	}
}
