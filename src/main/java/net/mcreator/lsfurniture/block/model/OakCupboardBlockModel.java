package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakCupboardTileEntity;

public class OakCupboardBlockModel extends GeoModel<OakCupboardTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakCupboardTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/cupboard_oak.png");
	}
}
