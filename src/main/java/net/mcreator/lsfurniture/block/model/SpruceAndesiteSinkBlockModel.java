package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceAndesiteSinkTileEntity;

public class SpruceAndesiteSinkBlockModel extends GeoModel<SpruceAndesiteSinkTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/block/sink_spruce_andesite.png");
	}
}
