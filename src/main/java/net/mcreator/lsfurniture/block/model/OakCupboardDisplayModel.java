package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakCupboardDisplayItem;

public class OakCupboardDisplayModel extends GeoModel<OakCupboardDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakCupboardDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/cupboard_oak.png");
	}
}
