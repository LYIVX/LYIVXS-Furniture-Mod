package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonCupboardTileEntity;

public class CrimsonCupboardBlockModel extends AnimatedGeoModel<CrimsonCupboardTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonCupboardTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/cupboard_crimson.png");
	}
}
