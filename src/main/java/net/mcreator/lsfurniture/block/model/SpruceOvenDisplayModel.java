package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceOvenDisplayItem;

public class SpruceOvenDisplayModel extends AnimatedGeoModel<SpruceOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/spruce_oven.png");
	}
}
