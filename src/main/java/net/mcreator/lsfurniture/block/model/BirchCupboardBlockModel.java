package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchCupboardTileEntity;

public class BirchCupboardBlockModel extends AnimatedGeoModel<BirchCupboardTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchCupboardTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/cupboard_birch.png");
	}
}
