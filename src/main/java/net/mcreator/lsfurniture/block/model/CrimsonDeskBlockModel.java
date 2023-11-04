package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonDeskTileEntity;

public class CrimsonDeskBlockModel extends AnimatedGeoModel<CrimsonDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/desk_crimson.png");
	}
}
