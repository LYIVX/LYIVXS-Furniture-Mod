package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceWardrobe2DisplayItem;

public class SpruceWardrobe2DisplayModel extends GeoModel<SpruceWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_spruce.png");
	}
}
