package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakBricksSinkTileEntity;

public class OakBricksSinkBlockModel extends AnimatedGeoModel<OakBricksSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakBricksSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakBricksSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakBricksSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_oak_bricks.png");
	}
}
