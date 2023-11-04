package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonNetherWartSinkTileEntity;

public class CrimsonNetherWartSinkBlockModel extends AnimatedGeoModel<CrimsonNetherWartSinkTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_crimson_nether_wart.png");
	}
}
