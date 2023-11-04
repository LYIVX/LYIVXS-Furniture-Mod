package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveDeskTileEntity;

public class MangroveDeskBlockModel extends AnimatedGeoModel<MangroveDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/desk_mangrove.png");
	}
}
