package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DioriteOvenTileEntity;

public class DioriteOvenBlockModel extends GeoModel<DioriteOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DioriteOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DioriteOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DioriteOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_diorite.png");
	}
}
