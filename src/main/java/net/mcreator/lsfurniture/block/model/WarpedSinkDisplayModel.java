package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedSinkDisplayItem;

public class WarpedSinkDisplayModel extends AnimatedGeoModel<WarpedSinkDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_warped.png");
	}
}
