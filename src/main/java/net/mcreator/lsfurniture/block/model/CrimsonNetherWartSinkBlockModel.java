package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonNetherWartSinkTileEntity;

public class CrimsonNetherWartSinkBlockModel extends GeoModel<CrimsonNetherWartSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonNetherWartSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonNetherWartSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonNetherWartSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_crimson_nether_wart.png");
	}
}
