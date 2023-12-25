package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakDrawerTileEntity;

public class OakDrawerBlockModel extends GeoModel<OakDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_oak.png");
	}
}
