package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DeepslateOvenDisplayItem;

public class DeepslateOvenDisplayModel extends AnimatedGeoModel<DeepslateOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DeepslateOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DeepslateOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DeepslateOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_deepslate.png");
	}
}
