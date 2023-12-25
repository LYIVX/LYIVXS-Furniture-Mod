package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonDrawerDisplayItem;

public class CrimsonDrawerDisplayModel extends GeoModel<CrimsonDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_crimson.png");
	}
}
