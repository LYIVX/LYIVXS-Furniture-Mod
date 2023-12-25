package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedOvenTileEntity;

public class WarpedOvenBlockModel extends GeoModel<WarpedOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_warped.png");
	}
}
