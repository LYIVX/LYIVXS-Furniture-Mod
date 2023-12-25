package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonWardrobeDisplayItem;

public class CrimsonWardrobeDisplayModel extends GeoModel<CrimsonWardrobeDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_crimson.png");
	}
}
