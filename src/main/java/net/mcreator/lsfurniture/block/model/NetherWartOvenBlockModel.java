package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.NetherWartOvenTileEntity;

public class NetherWartOvenBlockModel extends GeoModel<NetherWartOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(NetherWartOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NetherWartOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NetherWartOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_nether_wart.png");
	}
}
