package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleSinkDisplayItem;

public class JungleSinkDisplayModel extends AnimatedGeoModel<JungleSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_jungle.png");
	}
}
