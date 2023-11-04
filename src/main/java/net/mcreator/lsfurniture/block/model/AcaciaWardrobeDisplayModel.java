package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaWardrobeDisplayItem;

public class AcaciaWardrobeDisplayModel extends AnimatedGeoModel<AcaciaWardrobeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaWardrobeDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_acacia.png");
	}
}
