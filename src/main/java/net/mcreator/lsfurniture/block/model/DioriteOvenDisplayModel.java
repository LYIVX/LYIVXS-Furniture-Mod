package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DioriteOvenDisplayItem;

public class DioriteOvenDisplayModel extends GeoModel<DioriteOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DioriteOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DioriteOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DioriteOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_diorite.png");
	}
}
