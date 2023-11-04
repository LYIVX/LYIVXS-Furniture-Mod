package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaDioriteSinkTileEntity;

public class AcaciaDioriteSinkBlockModel extends AnimatedGeoModel<AcaciaDioriteSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaDioriteSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaDioriteSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaDioriteSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_acacia_diorite.png");
	}
}
