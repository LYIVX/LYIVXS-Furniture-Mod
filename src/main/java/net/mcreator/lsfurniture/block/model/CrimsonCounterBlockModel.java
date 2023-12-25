package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonCounterTileEntity;

public class CrimsonCounterBlockModel extends GeoModel<CrimsonCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_crimson.png");
	}
}
