package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakCupboardDisplayItem;

public class DarkOakCupboardDisplayModel extends AnimatedGeoModel<DarkOakCupboardDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakCupboardDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_cupboard.png");
	}
}
