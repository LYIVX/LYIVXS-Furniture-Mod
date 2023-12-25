package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedWartOvenDisplayItem;

public class WarpedWartOvenDisplayModel extends GeoModel<WarpedWartOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWartOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWartOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWartOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_warped_wart.png");
	}
}
