package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BricksOvenTileEntity;

public class BricksOvenBlockModel extends GeoModel<BricksOvenTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/block/oven_bricks.png");
	}
}
