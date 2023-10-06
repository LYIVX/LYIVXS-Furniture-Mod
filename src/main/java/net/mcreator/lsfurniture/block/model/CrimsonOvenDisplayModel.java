package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonOvenDisplayItem;

public class CrimsonOvenDisplayModel extends AnimatedGeoModel<CrimsonOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/crimson_oven.png");
	}
}
