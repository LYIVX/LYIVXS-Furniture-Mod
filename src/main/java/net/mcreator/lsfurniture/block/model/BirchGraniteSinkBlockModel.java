package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchGraniteSinkTileEntity;

public class BirchGraniteSinkBlockModel extends AnimatedGeoModel<BirchGraniteSinkTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_birch_granite.png");
	}
}
