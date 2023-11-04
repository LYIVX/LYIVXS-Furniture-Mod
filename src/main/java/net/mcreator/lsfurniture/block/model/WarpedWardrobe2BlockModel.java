package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedWardrobe2TileEntity;

public class WarpedWardrobe2BlockModel extends AnimatedGeoModel<WarpedWardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_warped.png");
	}
}
