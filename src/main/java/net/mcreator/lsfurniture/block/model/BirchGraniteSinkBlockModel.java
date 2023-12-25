package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchGraniteSinkTileEntity;

public class BirchGraniteSinkBlockModel extends GeoModel<BirchGraniteSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchGraniteSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchGraniteSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchGraniteSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_birch_granite.png");
	}
}
