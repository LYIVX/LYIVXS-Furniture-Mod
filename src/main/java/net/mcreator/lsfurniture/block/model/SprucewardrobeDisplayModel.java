package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SprucewardrobeDisplayItem;

public class SprucewardrobeDisplayModel extends AnimatedGeoModel<SprucewardrobeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SprucewardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SprucewardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SprucewardrobeDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_spruce.png");
	}
}
