package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakCounterTileEntity;

public class OakCounterBlockModel extends GeoModel<OakCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_oak.png");
	}
}
