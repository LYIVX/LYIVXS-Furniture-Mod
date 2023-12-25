package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceOvenDisplayItem;

public class SpruceOvenDisplayModel extends GeoModel<SpruceOvenDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/oven_spruce.png");
	}
}
