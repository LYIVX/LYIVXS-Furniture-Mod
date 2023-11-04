package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveSinkTileEntity;

public class MangroveSinkBlockModel extends AnimatedGeoModel<MangroveSinkTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_mangrove.png");
	}
}
