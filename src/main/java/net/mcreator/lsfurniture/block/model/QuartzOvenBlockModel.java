package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.QuartzOvenTileEntity;

public class QuartzOvenBlockModel extends GeoModel<QuartzOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(QuartzOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(QuartzOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(QuartzOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_quartz.png");
	}
}
