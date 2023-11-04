package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedDeskTileEntity;

public class WarpedDeskBlockModel extends AnimatedGeoModel<WarpedDeskTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/desk_warped.png");
	}
}
