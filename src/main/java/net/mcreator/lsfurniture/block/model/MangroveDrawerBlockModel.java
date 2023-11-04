package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveDrawerTileEntity;

public class MangroveDrawerBlockModel extends AnimatedGeoModel<MangroveDrawerTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/drawer_mangrove.png");
	}
}
