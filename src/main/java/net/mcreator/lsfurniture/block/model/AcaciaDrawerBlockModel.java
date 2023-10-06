package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaDrawerTileEntity;

public class AcaciaDrawerBlockModel extends AnimatedGeoModel<AcaciaDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/acacia_drawer.png");
	}
}
