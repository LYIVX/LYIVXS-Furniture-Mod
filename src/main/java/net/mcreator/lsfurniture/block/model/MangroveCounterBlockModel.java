package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveCounterTileEntity;

public class MangroveCounterBlockModel extends GeoModel<MangroveCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_mangrove.png");
	}
}
