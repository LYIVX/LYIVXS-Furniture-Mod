package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.FurnitureCrafterBetaDisplayItem;

public class FurnitureCrafterBetaDisplayModel extends AnimatedGeoModel<FurnitureCrafterBetaDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(FurnitureCrafterBetaDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/furniture_crafter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FurnitureCrafterBetaDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/furniture_crafter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FurnitureCrafterBetaDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/furniture_crafter.png");
	}
}
