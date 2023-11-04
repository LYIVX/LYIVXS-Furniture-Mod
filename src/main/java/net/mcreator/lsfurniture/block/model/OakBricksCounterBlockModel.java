package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakBricksCounterTileEntity;

public class OakBricksCounterBlockModel extends AnimatedGeoModel<OakBricksCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakBricksCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakBricksCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakBricksCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_oak_brick.png");
	}
}
