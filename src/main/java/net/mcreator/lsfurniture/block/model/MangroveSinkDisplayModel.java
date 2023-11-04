package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveSinkDisplayItem;

public class MangroveSinkDisplayModel extends AnimatedGeoModel<MangroveSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_mangrove.png");
	}
}
