package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.Darkoakwardrobe0DisplayItem;

public class Darkoakwardrobe0DisplayModel extends AnimatedGeoModel<Darkoakwardrobe0DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(Darkoakwardrobe0DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Darkoakwardrobe0DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Darkoakwardrobe0DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_wardrobe.png");
	}
}
