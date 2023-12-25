package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveDrawerTileEntity;

public class MangroveDrawerBlockModel extends GeoModel<MangroveDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_mangrove.png");
	}
}
