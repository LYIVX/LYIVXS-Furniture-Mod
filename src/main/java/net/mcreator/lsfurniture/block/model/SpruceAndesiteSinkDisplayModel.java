package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceAndesiteSinkDisplayItem;

public class SpruceAndesiteSinkDisplayModel extends AnimatedGeoModel<SpruceAndesiteSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceAndesiteSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceAndesiteSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceAndesiteSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_spruce_andesite.png");
	}
}
