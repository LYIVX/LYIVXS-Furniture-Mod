package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceSinkDisplayItem;

public class SpruceSinkDisplayModel extends GeoModel<SpruceSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_spruce.png");
	}
}
