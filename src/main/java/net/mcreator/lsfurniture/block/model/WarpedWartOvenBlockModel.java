package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedWartOvenTileEntity;

public class WarpedWartOvenBlockModel extends GeoModel<WarpedWartOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWartOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWartOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWartOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_warped_wart.png");
	}
}
