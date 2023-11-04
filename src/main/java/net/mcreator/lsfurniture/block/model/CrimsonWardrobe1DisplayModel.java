package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonWardrobe1DisplayItem;

public class CrimsonWardrobe1DisplayModel extends AnimatedGeoModel<CrimsonWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_crimson.png");
	}
}
