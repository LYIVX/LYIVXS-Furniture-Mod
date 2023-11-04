package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedWarpedWartCounterDisplayItem;

public class WarpedWarpedWartCounterDisplayModel extends AnimatedGeoModel<WarpedWarpedWartCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWarpedWartCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWarpedWartCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWarpedWartCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_warped_warped_wart.png");
	}
}
