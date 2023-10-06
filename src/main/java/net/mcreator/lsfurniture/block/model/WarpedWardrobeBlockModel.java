package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedWardrobeTileEntity;

public class WarpedWardrobeBlockModel extends AnimatedGeoModel<WarpedWardrobeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWardrobeTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/warped_wardrobe.png");
	}
}
