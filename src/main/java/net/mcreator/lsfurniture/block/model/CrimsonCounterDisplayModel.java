package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonCounterDisplayItem;

public class CrimsonCounterDisplayModel extends AnimatedGeoModel<CrimsonCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/crimson_counter.png");
	}
}
