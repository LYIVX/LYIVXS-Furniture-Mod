package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchCounterDisplayItem;

public class BirchCounterDisplayModel extends AnimatedGeoModel<BirchCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_birch.png");
	}
}
