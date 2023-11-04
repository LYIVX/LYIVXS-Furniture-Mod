package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.QuartzOvenDisplayItem;

public class QuartzOvenDisplayModel extends AnimatedGeoModel<QuartzOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(QuartzOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(QuartzOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(QuartzOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_quartz.png");
	}
}
