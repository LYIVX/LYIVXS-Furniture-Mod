package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedWarpedWartCounterDisplayItem;

public class WarpedWarpedWartCounterDisplayModel extends GeoModel<WarpedWarpedWartCounterDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/counter_warped_warped_wart.png");
	}
}
