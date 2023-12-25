package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonCupboardTileEntity;

public class CrimsonCupboardBlockModel extends GeoModel<CrimsonCupboardTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/block/cupboard_crimson.png");
	}
}
