package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BricksOvenTileEntity;

public class BricksOvenBlockModel extends AnimatedGeoModel<BricksOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BricksOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BricksOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BricksOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_bricks.png");
	}
}
