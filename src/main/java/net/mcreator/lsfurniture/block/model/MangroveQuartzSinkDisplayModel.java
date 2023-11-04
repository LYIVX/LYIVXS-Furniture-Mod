package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveQuartzSinkDisplayItem;

public class MangroveQuartzSinkDisplayModel extends AnimatedGeoModel<MangroveQuartzSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveQuartzSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveQuartzSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveQuartzSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_mangrove_quartz.png");
	}
}
