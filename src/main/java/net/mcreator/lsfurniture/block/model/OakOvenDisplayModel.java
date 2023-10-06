package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakOvenDisplayItem;

public class OakOvenDisplayModel extends AnimatedGeoModel<OakOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oak_oven.png");
	}
}
