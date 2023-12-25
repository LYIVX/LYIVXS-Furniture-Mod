package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveSinkTileEntity;

public class MangroveSinkBlockModel extends GeoModel<MangroveSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_mangrove.png");
	}
}
