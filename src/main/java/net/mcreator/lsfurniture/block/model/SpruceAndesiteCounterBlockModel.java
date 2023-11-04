package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceAndesiteCounterTileEntity;

public class SpruceAndesiteCounterBlockModel extends AnimatedGeoModel<SpruceAndesiteCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceAndesiteCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceAndesiteCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceAndesiteCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_spruce_andesite.png");
	}
}
