package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceWardrobe2DisplayItem;

public class SpruceWardrobe2DisplayModel extends AnimatedGeoModel<SpruceWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobetop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobetop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/spruce_wardrobe.png");
	}
}
