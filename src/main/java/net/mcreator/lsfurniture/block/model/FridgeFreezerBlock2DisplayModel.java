package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.FridgeFreezerBlock2DisplayItem;

public class FridgeFreezerBlock2DisplayModel extends AnimatedGeoModel<FridgeFreezerBlock2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlock2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/fidge_frezzer2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlock2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/fidge_frezzer2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlock2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/iron_block.png");
	}
}
