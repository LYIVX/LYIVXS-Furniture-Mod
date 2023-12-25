package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveOvenDisplayItem;

public class MangroveOvenDisplayModel extends GeoModel<MangroveOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_mangrove.png");
	}
}
