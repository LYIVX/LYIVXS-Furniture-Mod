package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakOvenDisplayItem;

public class DarkOakOvenDisplayModel extends GeoModel<DarkOakOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_dark_oak.png");
	}
}
