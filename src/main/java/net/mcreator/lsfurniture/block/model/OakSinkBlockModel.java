package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakSinkTileEntity;

public class OakSinkBlockModel extends AnimatedGeoModel<OakSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oak_sink.png");
	}
}
