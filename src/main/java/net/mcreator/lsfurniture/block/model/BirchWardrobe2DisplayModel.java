package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchWardrobe2DisplayItem;

public class BirchWardrobe2DisplayModel extends AnimatedGeoModel<BirchWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_birch.png");
	}
}
