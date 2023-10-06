package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceCounterDisplayItem;

public class SpruceCounterDisplayModel extends AnimatedGeoModel<SpruceCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/spruce_counter.png");
	}
}
