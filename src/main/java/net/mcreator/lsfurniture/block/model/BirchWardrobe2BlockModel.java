package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchWardrobe2TileEntity;

public class BirchWardrobe2BlockModel extends AnimatedGeoModel<BirchWardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchWardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_birch.png");
	}
}
