package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakSinkDisplayItem;

public class OakSinkDisplayModel extends GeoModel<OakSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_oak.png");
	}
}
