package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonSinkTileEntity;

public class CrimsonSinkBlockModel extends AnimatedGeoModel<CrimsonSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/crimson_sink.png");
	}
}
