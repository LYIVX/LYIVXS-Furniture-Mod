package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.Darkoakwardrobe2DisplayItem;

public class Darkoakwardrobe2DisplayModel extends AnimatedGeoModel<Darkoakwardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(Darkoakwardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Darkoakwardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Darkoakwardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_dark_oak.png");
	}
}
