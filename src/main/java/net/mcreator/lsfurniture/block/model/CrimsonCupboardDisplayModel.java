package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonCupboardDisplayItem;

public class CrimsonCupboardDisplayModel extends GeoModel<CrimsonCupboardDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonCupboardDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/cupboard_crimson.png");
	}
}
