package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceSinkTileEntity;

public class SpruceSinkBlockModel extends AnimatedGeoModel<SpruceSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_spruce.png");
	}
}
