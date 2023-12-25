package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveQuartzCounterDisplayItem;

public class MangroveQuartzCounterDisplayModel extends GeoModel<MangroveQuartzCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveQuartzCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveQuartzCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveQuartzCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_mangrove_quartz.png");
	}
}
