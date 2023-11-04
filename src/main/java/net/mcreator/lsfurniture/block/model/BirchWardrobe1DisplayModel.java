package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchWardrobe1DisplayItem;

public class BirchWardrobe1DisplayModel extends AnimatedGeoModel<BirchWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_birch.png");
	}
}
