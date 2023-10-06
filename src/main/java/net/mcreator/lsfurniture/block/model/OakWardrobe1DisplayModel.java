package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakWardrobe1DisplayItem;

public class OakWardrobe1DisplayModel extends AnimatedGeoModel<OakWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_buttom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_buttom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oak_wardrobe.png");
	}
}
