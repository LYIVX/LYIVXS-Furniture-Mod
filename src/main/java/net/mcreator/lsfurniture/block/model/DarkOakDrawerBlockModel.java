package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakDrawerTileEntity;

public class DarkOakDrawerBlockModel extends AnimatedGeoModel<DarkOakDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/drawer_dark_oak.png");
	}
}
