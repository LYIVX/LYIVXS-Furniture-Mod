package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceDeskTileEntity;

public class SpruceDeskBlockModel extends GeoModel<SpruceDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/desk_spruce.png");
	}
}
