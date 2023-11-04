package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceAndesiteSinkTileEntity;

public class SpruceAndesiteSinkBlockModel extends AnimatedGeoModel<SpruceAndesiteSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceAndesiteSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceAndesiteSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceAndesiteSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_spruce_andesite.png");
	}
}
