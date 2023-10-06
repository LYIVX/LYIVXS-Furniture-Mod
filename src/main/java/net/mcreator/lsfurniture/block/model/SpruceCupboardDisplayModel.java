package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceCupboardDisplayItem;

public class SpruceCupboardDisplayModel extends AnimatedGeoModel<SpruceCupboardDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceCupboardDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/spruce_cupboard.png");
	}
}
