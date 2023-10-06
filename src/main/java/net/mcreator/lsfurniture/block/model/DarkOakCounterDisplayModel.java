package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakCounterDisplayItem;

public class DarkOakCounterDisplayModel extends AnimatedGeoModel<DarkOakCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_counter.png");
	}
}
