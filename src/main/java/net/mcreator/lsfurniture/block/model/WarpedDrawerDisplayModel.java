package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedDrawerDisplayItem;

public class WarpedDrawerDisplayModel extends GeoModel<WarpedDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_warped.png");
	}
}
