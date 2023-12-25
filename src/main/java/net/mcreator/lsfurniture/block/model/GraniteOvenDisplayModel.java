package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.GraniteOvenDisplayItem;

public class GraniteOvenDisplayModel extends GeoModel<GraniteOvenDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/oven_granite.png");
	}
}
