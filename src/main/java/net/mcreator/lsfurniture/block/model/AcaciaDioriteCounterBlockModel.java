package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaDioriteCounterTileEntity;

public class AcaciaDioriteCounterBlockModel extends AnimatedGeoModel<AcaciaDioriteCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaDioriteCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaDioriteCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaDioriteCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_acacia_diorite.png");
	}
}
