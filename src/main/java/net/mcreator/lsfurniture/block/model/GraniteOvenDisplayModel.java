package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.GraniteOvenDisplayItem;

public class GraniteOvenDisplayModel extends AnimatedGeoModel<GraniteOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GraniteOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GraniteOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GraniteOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_granite.png");
	}
}
