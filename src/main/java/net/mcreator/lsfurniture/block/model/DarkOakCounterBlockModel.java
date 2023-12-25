package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakCounterTileEntity;

public class DarkOakCounterBlockModel extends GeoModel<DarkOakCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_dark_oak.png");
	}
}
