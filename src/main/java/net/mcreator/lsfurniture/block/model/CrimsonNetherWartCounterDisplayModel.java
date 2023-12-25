package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonNetherWartCounterDisplayItem;

public class CrimsonNetherWartCounterDisplayModel extends GeoModel<CrimsonNetherWartCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonNetherWartCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonNetherWartCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonNetherWartCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_crimson_nether_wart.png");
	}
}
