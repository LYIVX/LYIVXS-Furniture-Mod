package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchGraniteSinkDisplayItem;

public class BirchGraniteSinkDisplayModel extends GeoModel<BirchGraniteSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchGraniteSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchGraniteSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchGraniteSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_birch_granite.png");
	}
}
