package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedWardrobe1DisplayItem;

public class WarpedWardrobe1DisplayModel extends AnimatedGeoModel<WarpedWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_buttom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_buttom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/warped_wardrobe.png");
	}
}
