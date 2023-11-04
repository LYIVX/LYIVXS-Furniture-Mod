package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveCounterDisplayItem;

public class MangroveCounterDisplayModel extends AnimatedGeoModel<MangroveCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_mangrove.png");
	}
}
