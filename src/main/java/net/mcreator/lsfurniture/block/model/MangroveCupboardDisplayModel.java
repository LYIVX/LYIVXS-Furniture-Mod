package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveCupboardDisplayItem;

public class MangroveCupboardDisplayModel extends GeoModel<MangroveCupboardDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveCupboardDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/cupboard_mangrove.png");
	}
}
