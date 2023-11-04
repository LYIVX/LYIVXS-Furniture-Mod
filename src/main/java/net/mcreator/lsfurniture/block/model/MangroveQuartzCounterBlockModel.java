package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveQuartzCounterTileEntity;

public class MangroveQuartzCounterBlockModel extends AnimatedGeoModel<MangroveQuartzCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveQuartzCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveQuartzCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveQuartzCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_mangrove_quartz.png");
	}
}
