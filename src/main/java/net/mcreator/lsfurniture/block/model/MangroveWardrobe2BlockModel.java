package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveWardrobe2TileEntity;

public class MangroveWardrobe2BlockModel extends AnimatedGeoModel<MangroveWardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobetop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobetop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveWardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/mangrove_wardrobe.png");
	}
}
