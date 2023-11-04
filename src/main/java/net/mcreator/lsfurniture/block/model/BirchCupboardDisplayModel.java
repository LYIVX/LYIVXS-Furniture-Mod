package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchCupboardDisplayItem;

public class BirchCupboardDisplayModel extends AnimatedGeoModel<BirchCupboardDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchCupboardDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/cupboard_birch.png");
	}
}
