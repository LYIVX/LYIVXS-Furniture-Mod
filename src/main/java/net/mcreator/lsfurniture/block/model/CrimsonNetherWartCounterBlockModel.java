package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonNetherWartCounterTileEntity;

public class CrimsonNetherWartCounterBlockModel extends GeoModel<CrimsonNetherWartCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonNetherWartCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonNetherWartCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonNetherWartCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_crimson_nether_wart.png");
	}
}
