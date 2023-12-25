package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.BirchGraniteCounterDisplayItem;

public class BirchGraniteCounterDisplayModel extends GeoModel<BirchGraniteCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BirchGraniteCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchGraniteCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchGraniteCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_birch_granite.png");
	}
}
