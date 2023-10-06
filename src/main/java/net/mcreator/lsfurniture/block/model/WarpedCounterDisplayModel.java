package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedCounterDisplayItem;

public class WarpedCounterDisplayModel extends AnimatedGeoModel<WarpedCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/warped_counter.png");
	}
}
