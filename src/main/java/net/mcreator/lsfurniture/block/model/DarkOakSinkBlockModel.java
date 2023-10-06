package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakSinkTileEntity;

public class DarkOakSinkBlockModel extends AnimatedGeoModel<DarkOakSinkTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_sink.png");
	}
}
