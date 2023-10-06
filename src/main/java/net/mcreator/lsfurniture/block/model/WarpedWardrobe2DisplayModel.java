package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedWardrobe2DisplayItem;

public class WarpedWardrobe2DisplayModel extends AnimatedGeoModel<WarpedWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobetop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobetop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/warped_wardrobe.png");
	}
}
