package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedDeskTileEntity;

public class WarpedDeskBlockModel extends GeoModel<WarpedDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/desk_warped.png");
	}
}
