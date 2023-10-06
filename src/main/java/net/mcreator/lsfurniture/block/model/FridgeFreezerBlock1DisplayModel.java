package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.FridgeFreezerBlock1DisplayItem;

public class FridgeFreezerBlock1DisplayModel extends AnimatedGeoModel<FridgeFreezerBlock1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlock1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/fidge_frezzer_1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlock1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/fidge_frezzer_1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlock1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/iron_block.png");
	}
}
