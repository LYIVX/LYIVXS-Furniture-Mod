package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchOvenDisplayItem;

public class BirchOvenDisplayModel extends AnimatedGeoModel<BirchOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_birch.png");
	}
}
