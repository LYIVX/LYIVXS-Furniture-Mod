package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaOvenDisplayItem;

public class AcaciaOvenDisplayModel extends AnimatedGeoModel<AcaciaOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_acacia.png");
	}
}
