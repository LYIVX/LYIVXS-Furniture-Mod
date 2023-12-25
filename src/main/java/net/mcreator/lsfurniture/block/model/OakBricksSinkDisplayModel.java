package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakBricksSinkDisplayItem;

public class OakBricksSinkDisplayModel extends GeoModel<OakBricksSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakBricksSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakBricksSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakBricksSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_oak_bricks.png");
	}
}
