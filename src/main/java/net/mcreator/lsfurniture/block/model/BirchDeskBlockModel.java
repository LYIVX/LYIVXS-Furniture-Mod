package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchDeskTileEntity;

public class BirchDeskBlockModel extends AnimatedGeoModel<BirchDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/birch_desk.png");
	}
}
