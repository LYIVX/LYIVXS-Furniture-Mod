package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceSinkTileEntity;

public class SpruceSinkBlockModel extends GeoModel<SpruceSinkTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/block/sink_spruce.png");
	}
}
