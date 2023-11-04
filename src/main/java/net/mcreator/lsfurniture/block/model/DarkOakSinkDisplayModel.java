package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakSinkDisplayItem;

public class DarkOakSinkDisplayModel extends AnimatedGeoModel<DarkOakSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_dark_oak.png");
	}
}
