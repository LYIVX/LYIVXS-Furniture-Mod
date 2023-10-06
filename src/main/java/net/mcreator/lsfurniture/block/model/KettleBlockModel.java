package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.KettleTileEntity;

public class KettleBlockModel extends AnimatedGeoModel<KettleTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(KettleTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/kettle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KettleTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/kettle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KettleTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/kettle.png");
	}
}
