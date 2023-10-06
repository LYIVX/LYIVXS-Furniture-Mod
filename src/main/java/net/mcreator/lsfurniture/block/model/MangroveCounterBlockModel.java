package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveCounterTileEntity;

public class MangroveCounterBlockModel extends AnimatedGeoModel<MangroveCounterTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/mangrove_counter.png");
	}
}
