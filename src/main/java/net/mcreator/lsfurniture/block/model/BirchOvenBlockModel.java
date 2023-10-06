package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchOvenTileEntity;

public class BirchOvenBlockModel extends AnimatedGeoModel<BirchOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/birch_oven.png");
	}
}
