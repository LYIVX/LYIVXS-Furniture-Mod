package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakDrawerTileEntity;

public class OakDrawerBlockModel extends AnimatedGeoModel<OakDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oak_drawer.png");
	}
}
