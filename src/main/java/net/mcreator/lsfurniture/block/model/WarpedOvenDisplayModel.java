package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedOvenDisplayItem;

public class WarpedOvenDisplayModel extends AnimatedGeoModel<WarpedOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/warped_oven.png");
	}
}
