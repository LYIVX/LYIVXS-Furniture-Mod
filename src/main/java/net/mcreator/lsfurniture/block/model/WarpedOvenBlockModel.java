package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedOvenTileEntity;

public class WarpedOvenBlockModel extends AnimatedGeoModel<WarpedOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_warped.png");
	}
}
