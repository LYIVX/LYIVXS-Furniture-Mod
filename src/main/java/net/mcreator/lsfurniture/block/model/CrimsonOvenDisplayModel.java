package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonOvenDisplayItem;

public class CrimsonOvenDisplayModel extends GeoModel<CrimsonOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_crimson.png");
	}
}
