package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceOvenTileEntity;

public class SpruceOvenBlockModel extends AnimatedGeoModel<SpruceOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_spruce.png");
	}
}
