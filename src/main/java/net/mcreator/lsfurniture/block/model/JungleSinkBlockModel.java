package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleSinkTileEntity;

public class JungleSinkBlockModel extends AnimatedGeoModel<JungleSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_jungle.png");
	}
}
