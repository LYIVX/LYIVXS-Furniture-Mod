package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchDrawerTileEntity;

public class BirchDrawerBlockModel extends AnimatedGeoModel<BirchDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/drawer_birch.png");
	}
}
