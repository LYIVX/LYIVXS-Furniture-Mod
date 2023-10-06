package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.Darkoakwardrobe1DisplayItem;

public class Darkoakwardrobe1DisplayModel extends AnimatedGeoModel<Darkoakwardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(Darkoakwardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_buttom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Darkoakwardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_buttom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Darkoakwardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_wardrobe.png");
	}
}
