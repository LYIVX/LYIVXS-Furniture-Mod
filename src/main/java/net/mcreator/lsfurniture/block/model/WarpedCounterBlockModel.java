package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedCounterTileEntity;

public class WarpedCounterBlockModel extends AnimatedGeoModel<WarpedCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_warped.png");
	}
}
