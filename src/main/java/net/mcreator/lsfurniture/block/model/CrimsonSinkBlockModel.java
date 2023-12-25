package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonSinkTileEntity;

public class CrimsonSinkBlockModel extends GeoModel<CrimsonSinkTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/block/sink_crimson.png");
	}
}
