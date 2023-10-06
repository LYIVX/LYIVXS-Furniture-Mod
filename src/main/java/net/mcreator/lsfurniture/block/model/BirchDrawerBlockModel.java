package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchDrawerTileEntity;

public class BirchDrawerBlockModel extends AnimatedGeoModel<BirchDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/birch_drawer.png");
	}
}
