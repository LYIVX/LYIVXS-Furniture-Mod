package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedWardrobe1DisplayItem;

public class WarpedWardrobe1DisplayModel extends GeoModel<WarpedWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_warped.png");
	}
}
