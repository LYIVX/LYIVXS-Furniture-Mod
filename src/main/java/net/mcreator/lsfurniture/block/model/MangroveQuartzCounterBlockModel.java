package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveQuartzCounterTileEntity;

public class MangroveQuartzCounterBlockModel extends GeoModel<MangroveQuartzCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveQuartzCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveQuartzCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveQuartzCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_mangrove_quartz.png");
	}
}
