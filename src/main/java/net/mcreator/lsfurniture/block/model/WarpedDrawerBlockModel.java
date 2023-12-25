package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedDrawerTileEntity;

public class WarpedDrawerBlockModel extends GeoModel<WarpedDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_warped.png");
	}
}
