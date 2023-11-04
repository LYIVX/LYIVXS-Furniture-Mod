package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakDeepslateCounterDisplayItem;

public class DarkOakDeepslateCounterDisplayModel extends AnimatedGeoModel<DarkOakDeepslateCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakDeepslateCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakDeepslateCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakDeepslateCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_dark_oak_deepslate.png");
	}
}
