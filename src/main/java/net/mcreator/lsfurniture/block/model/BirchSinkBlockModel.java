package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchSinkTileEntity;

public class BirchSinkBlockModel extends GeoModel<BirchSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_birch.png");
	}
}
