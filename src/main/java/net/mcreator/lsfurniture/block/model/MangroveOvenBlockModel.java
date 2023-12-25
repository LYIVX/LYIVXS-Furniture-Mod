package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveOvenTileEntity;

public class MangroveOvenBlockModel extends GeoModel<MangroveOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_mangrove.png");
	}
}
