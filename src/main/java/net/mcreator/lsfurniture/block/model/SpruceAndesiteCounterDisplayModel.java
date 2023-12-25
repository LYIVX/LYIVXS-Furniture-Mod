package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceAndesiteCounterDisplayItem;

public class SpruceAndesiteCounterDisplayModel extends GeoModel<SpruceAndesiteCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceAndesiteCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceAndesiteCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceAndesiteCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_spruce_andesite.png");
	}
}
