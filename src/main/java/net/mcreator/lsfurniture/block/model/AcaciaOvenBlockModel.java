package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaOvenTileEntity;

public class AcaciaOvenBlockModel extends GeoModel<AcaciaOvenTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/block/oven_acacia.png");
	}
}
