package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakCounterDisplayItem;

public class OakCounterDisplayModel extends AnimatedGeoModel<OakCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter-oak.png");
	}
}
