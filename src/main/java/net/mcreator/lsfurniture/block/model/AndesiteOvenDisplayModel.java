package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AndesiteOvenDisplayItem;

public class AndesiteOvenDisplayModel extends AnimatedGeoModel<AndesiteOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AndesiteOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AndesiteOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AndesiteOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_andesite.png");
	}
}
