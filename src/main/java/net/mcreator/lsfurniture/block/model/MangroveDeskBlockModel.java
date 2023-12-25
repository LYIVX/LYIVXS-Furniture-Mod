package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveDeskTileEntity;

public class MangroveDeskBlockModel extends GeoModel<MangroveDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/desk_mangrove.png");
	}
}
