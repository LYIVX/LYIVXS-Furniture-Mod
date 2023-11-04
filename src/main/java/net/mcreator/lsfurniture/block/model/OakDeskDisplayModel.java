package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakDeskDisplayItem;

public class OakDeskDisplayModel extends AnimatedGeoModel<OakDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/desk_oak.png");
	}
}
