package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DeepslateOvenTileEntity;

public class DeepslateOvenBlockModel extends GeoModel<DeepslateOvenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DeepslateOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DeepslateOvenTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DeepslateOvenTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_deepslate.png");
	}
}
