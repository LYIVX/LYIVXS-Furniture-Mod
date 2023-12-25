package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakDrawerDisplayItem;

public class DarkOakDrawerDisplayModel extends GeoModel<DarkOakDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_dark_oak.png");
	}
}
