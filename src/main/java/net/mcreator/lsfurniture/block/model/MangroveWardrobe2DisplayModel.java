package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveWardrobe2DisplayItem;

public class MangroveWardrobe2DisplayModel extends AnimatedGeoModel<MangroveWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobetop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobetop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/mangrove_wardrobe.png");
	}
}
