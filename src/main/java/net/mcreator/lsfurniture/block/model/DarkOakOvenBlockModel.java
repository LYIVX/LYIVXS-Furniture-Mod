package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakOvenTileEntity;

public class DarkOakOvenBlockModel extends GeoModel<DarkOakOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_dark_oak.png");
	}
}
