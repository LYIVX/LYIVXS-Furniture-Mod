package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakWardrobe2DisplayItem;

public class OakWardrobe2DisplayModel extends AnimatedGeoModel<OakWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobetop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobetop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oak_wardrobe.png");
	}
}
