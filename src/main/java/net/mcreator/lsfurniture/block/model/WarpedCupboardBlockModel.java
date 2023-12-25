package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedCupboardTileEntity;

public class WarpedCupboardBlockModel extends GeoModel<WarpedCupboardTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedCupboardTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/cupboard_warped.png");
	}
}
