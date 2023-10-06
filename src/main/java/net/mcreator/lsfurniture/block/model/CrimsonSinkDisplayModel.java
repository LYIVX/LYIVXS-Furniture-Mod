package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonSinkDisplayItem;

public class CrimsonSinkDisplayModel extends AnimatedGeoModel<CrimsonSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/crimson_sink.png");
	}
}
