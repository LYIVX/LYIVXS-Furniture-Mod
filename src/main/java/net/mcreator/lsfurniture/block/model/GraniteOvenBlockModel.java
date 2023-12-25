package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.GraniteOvenTileEntity;

public class GraniteOvenBlockModel extends GeoModel<GraniteOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GraniteOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GraniteOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GraniteOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_granite.png");
	}
}
