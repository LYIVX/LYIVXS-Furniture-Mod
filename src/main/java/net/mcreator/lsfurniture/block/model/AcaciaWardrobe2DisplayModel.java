package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaWardrobe2DisplayItem;

public class AcaciaWardrobe2DisplayModel extends AnimatedGeoModel<AcaciaWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobetop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobetop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/acacia_wardrobe.png");
	}
}
