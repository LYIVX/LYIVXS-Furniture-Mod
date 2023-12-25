package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedSinkTileEntity;

public class WarpedSinkBlockModel extends GeoModel<WarpedSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_warped.png");
	}
}
