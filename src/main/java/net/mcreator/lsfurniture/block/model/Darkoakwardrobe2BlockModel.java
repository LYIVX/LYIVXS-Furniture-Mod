package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.Darkoakwardrobe2TileEntity;

public class Darkoakwardrobe2BlockModel extends AnimatedGeoModel<Darkoakwardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(Darkoakwardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobetop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Darkoakwardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobetop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Darkoakwardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_wardrobe.png");
	}
}
