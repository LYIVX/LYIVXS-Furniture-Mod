package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchWardrobeTileEntity;

public class BirchWardrobeBlockModel extends AnimatedGeoModel<BirchWardrobeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchWardrobeTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/birch_wardrobe.png");
	}
}
