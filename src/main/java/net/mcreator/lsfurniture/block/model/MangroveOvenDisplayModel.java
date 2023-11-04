package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveOvenDisplayItem;

public class MangroveOvenDisplayModel extends AnimatedGeoModel<MangroveOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_mangrove.png");
	}
}
