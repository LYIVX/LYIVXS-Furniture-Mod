package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakOvenDisplayItem;

public class OakOvenDisplayModel extends GeoModel<OakOvenDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/oven_oak.png");
	}
}
