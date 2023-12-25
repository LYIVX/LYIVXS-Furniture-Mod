package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BricksOvenDisplayItem;

public class BricksOvenDisplayModel extends GeoModel<BricksOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BricksOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BricksOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BricksOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_bricks.png");
	}
}
