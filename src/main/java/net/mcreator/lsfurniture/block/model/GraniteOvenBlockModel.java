package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.GraniteOvenTileEntity;

public class GraniteOvenBlockModel extends AnimatedGeoModel<GraniteOvenTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_granite.png");
	}
}
