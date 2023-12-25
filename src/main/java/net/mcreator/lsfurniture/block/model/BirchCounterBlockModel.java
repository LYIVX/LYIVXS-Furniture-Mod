package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchCounterTileEntity;

public class BirchCounterBlockModel extends GeoModel<BirchCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_birch.png");
	}
}
