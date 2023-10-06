package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveDeskDisplayItem;

public class MangroveDeskDisplayModel extends AnimatedGeoModel<MangroveDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/mangrove_desk.png");
	}
}
