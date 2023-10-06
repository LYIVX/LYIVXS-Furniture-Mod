package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakWardrobe2TileEntity;

public class OakWardrobe2BlockModel extends AnimatedGeoModel<OakWardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobetop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobetop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakWardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oak_wardrobe.png");
	}
}
