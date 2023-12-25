package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakSinkTileEntity;

public class DarkOakSinkBlockModel extends GeoModel<DarkOakSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_dark_oak.png");
	}
}
