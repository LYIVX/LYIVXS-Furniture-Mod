package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleOvenDisplayItem;

public class JungleOvenDisplayModel extends GeoModel<JungleOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_jungle.png");
	}
}
