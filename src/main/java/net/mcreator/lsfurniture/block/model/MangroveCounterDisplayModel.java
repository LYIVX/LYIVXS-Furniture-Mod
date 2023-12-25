package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveCounterDisplayItem;

public class MangroveCounterDisplayModel extends GeoModel<MangroveCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_mangrove.png");
	}
}
