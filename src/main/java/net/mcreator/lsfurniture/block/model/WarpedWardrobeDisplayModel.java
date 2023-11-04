package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedWardrobeDisplayItem;

public class WarpedWardrobeDisplayModel extends AnimatedGeoModel<WarpedWardrobeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWardrobeDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_warped.png");
	}
}
