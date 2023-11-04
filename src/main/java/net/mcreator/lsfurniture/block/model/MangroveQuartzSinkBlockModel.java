package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveQuartzSinkTileEntity;

public class MangroveQuartzSinkBlockModel extends AnimatedGeoModel<MangroveQuartzSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveQuartzSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveQuartzSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveQuartzSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_mangrove_quartz.png");
	}
}
