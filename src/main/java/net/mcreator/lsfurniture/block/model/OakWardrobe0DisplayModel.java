package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakWardrobe0DisplayItem;

public class OakWardrobe0DisplayModel extends GeoModel<OakWardrobe0DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakWardrobe0DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakWardrobe0DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakWardrobe0DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_oak.png");
	}
}
