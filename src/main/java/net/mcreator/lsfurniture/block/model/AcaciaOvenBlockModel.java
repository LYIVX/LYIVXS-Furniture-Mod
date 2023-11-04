package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaOvenTileEntity;

public class AcaciaOvenBlockModel extends AnimatedGeoModel<AcaciaOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_acacia.png");
	}
}
