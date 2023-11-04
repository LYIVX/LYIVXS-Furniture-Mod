package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceDeskDisplayItem;

public class SpruceDeskDisplayModel extends AnimatedGeoModel<SpruceDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/desk_spruce.png");
	}
}
