package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedSinkDisplayItem;

public class WarpedSinkDisplayModel extends GeoModel<WarpedSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_warped.png");
	}
}
