package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveWardrobeTileEntity;

public class MangroveWardrobeBlockModel extends AnimatedGeoModel<MangroveWardrobeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveWardrobeTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/mangrove_wardrobe.png");
	}
}
