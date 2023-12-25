package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedWarpedWartCounterTileEntity;

public class WarpedWarpedWartCounterBlockModel extends GeoModel<WarpedWarpedWartCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWarpedWartCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWarpedWartCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWarpedWartCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_warped_warped_wart.png");
	}
}
