package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchWardrobeDisplayItem;

public class BirchWardrobeDisplayModel extends GeoModel<BirchWardrobeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchWardrobeDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_birch.png");
	}
}
