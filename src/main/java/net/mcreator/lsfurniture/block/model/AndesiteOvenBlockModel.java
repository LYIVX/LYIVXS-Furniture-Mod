package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AndesiteOvenTileEntity;

public class AndesiteOvenBlockModel extends AnimatedGeoModel<AndesiteOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AndesiteOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AndesiteOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AndesiteOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_andesite.png");
	}
}
