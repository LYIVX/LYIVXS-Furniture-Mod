package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakOvenTileEntity;

public class OakOvenBlockModel extends GeoModel<OakOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_oak.png");
	}
}
