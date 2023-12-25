package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceAndesiteSinkDisplayItem;

public class SpruceAndesiteSinkDisplayModel extends GeoModel<SpruceAndesiteSinkDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/sink_spruce_andesite.png");
	}
}
