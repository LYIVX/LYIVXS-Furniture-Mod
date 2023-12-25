package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedWarpedWartSinkDisplayItem;

public class WarpedWarpedWartSinkDisplayModel extends GeoModel<WarpedWarpedWartSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWarpedWartSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWarpedWartSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWarpedWartSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_warped_warped_wart.png");
	}
}
