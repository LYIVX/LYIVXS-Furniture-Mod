package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchDrawerDisplayItem;

public class BirchDrawerDisplayModel extends GeoModel<BirchDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_birch.png");
	}
}
