package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveWardrobe1DisplayItem;

public class MangroveWardrobe1DisplayModel extends AnimatedGeoModel<MangroveWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_buttom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_buttom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/mangrove_wardrobe.png");
	}
}
