package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.FridgeFreezerBlockDisplayItem;

public class FridgeFreezerBlockDisplayModel extends AnimatedGeoModel<FridgeFreezerBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlockDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/fidge_frezzer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlockDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/fidge_frezzer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlockDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/iron_block.png");
	}
}
