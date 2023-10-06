package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchSinkDisplayItem;

public class BirchSinkDisplayModel extends AnimatedGeoModel<BirchSinkDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/birch_sink.png");
	}
}
