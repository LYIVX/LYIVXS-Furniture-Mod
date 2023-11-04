package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleOvenDisplayItem;

public class JungleOvenDisplayModel extends AnimatedGeoModel<JungleOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_jungle.png");
	}
}
