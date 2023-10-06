package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonWardrobeDisplayItem;

public class CrimsonWardrobeDisplayModel extends AnimatedGeoModel<CrimsonWardrobeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonWardrobeDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/crimson_wardrobe.png");
	}
}
