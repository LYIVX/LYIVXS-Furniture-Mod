package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveWardrobeDisplayItem;

public class MangroveWardrobeDisplayModel extends GeoModel<MangroveWardrobeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveWardrobeDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_mangrove.png");
	}
}
