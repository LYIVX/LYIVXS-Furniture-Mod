package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakDeepslateCounterTileEntity;

public class DarkOakDeepslateCounterBlockModel extends GeoModel<DarkOakDeepslateCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakDeepslateCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakDeepslateCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakDeepslateCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_dark_oak_deepslate.png");
	}
}
