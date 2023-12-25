package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonDrawerTileEntity;

public class CrimsonDrawerBlockModel extends GeoModel<CrimsonDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_crimson.png");
	}
}
