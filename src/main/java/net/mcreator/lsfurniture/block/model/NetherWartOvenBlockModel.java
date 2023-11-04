package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.NetherWartOvenTileEntity;

public class NetherWartOvenBlockModel extends AnimatedGeoModel<NetherWartOvenTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_nether_wart.png");
	}
}
