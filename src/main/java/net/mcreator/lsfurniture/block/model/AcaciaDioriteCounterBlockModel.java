package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaDioriteCounterTileEntity;

public class AcaciaDioriteCounterBlockModel extends GeoModel<AcaciaDioriteCounterTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/block/counter_acacia_diorite.png");
	}
}
