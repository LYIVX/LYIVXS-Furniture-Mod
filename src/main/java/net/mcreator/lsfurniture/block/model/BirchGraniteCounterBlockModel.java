package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchGraniteCounterTileEntity;

public class BirchGraniteCounterBlockModel extends AnimatedGeoModel<BirchGraniteCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchGraniteCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchGraniteCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchGraniteCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_birch_granite.png");
	}
}
