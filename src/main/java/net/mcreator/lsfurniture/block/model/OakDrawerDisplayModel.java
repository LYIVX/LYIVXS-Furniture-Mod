package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakDrawerDisplayItem;

public class OakDrawerDisplayModel extends GeoModel<OakDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_oak.png");
	}
}
