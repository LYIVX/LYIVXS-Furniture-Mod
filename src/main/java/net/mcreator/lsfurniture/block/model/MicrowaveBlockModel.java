package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MicrowaveTileEntity;

public class MicrowaveBlockModel extends GeoModel<MicrowaveTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MicrowaveTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/microwave.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MicrowaveTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/microwave.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MicrowaveTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/microwave.png");
	}
}
