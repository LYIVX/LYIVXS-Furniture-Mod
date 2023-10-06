package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaWardrobe1DisplayItem;

public class AcaciaWardrobe1DisplayModel extends AnimatedGeoModel<AcaciaWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_buttom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_buttom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/acacia_wardrobe.png");
	}
}
