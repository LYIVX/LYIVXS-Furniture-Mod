package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceCounterTileEntity;

public class SpruceCounterBlockModel extends GeoModel<SpruceCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_spruce.png");
	}
}
