package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaWardrobe2DisplayItem;

public class AcaciaWardrobe2DisplayModel extends GeoModel<AcaciaWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_acacia.png");
	}
}
