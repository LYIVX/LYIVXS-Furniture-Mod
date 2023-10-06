package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaCounterTileEntity;

public class AcaciaCounterBlockModel extends AnimatedGeoModel<AcaciaCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/acacia_counter.png");
	}
}
