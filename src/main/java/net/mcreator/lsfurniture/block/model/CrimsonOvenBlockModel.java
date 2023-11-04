package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonOvenTileEntity;

public class CrimsonOvenBlockModel extends AnimatedGeoModel<CrimsonOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_crimson.png");
	}
}
