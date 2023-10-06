package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakDeskTileEntity;

public class OakDeskBlockModel extends AnimatedGeoModel<OakDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oak_desk.png");
	}
}
