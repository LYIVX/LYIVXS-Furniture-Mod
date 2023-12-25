package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchSinkDisplayItem;

public class BirchSinkDisplayModel extends GeoModel<BirchSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_birch.png");
	}
}
