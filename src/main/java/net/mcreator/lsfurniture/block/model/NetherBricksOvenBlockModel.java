package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.NetherBricksOvenTileEntity;

public class NetherBricksOvenBlockModel extends GeoModel<NetherBricksOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(NetherBricksOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NetherBricksOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NetherBricksOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_nether_bricks.png");
	}
}
