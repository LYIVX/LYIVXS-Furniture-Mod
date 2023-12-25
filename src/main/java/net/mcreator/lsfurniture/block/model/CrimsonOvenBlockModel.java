package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonOvenTileEntity;

public class CrimsonOvenBlockModel extends GeoModel<CrimsonOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_crimson.png");
	}
}
