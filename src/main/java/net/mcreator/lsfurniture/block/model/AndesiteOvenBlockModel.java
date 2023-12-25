package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AndesiteOvenTileEntity;

public class AndesiteOvenBlockModel extends GeoModel<AndesiteOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AndesiteOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AndesiteOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AndesiteOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_andesite.png");
	}
}
