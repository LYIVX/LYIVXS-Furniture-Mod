package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaWardrobeTileEntity;

public class AcaciaWardrobeBlockModel extends AnimatedGeoModel<AcaciaWardrobeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaWardrobeTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/acacia_wardrobe.png");
	}
}
