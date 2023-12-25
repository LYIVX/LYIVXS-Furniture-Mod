package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakWardrobe2DisplayItem;

public class OakWardrobe2DisplayModel extends GeoModel<OakWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_oak.png");
	}
}
