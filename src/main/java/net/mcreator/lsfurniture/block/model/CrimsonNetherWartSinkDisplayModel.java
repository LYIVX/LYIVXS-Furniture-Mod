package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonNetherWartSinkDisplayItem;

public class CrimsonNetherWartSinkDisplayModel extends GeoModel<CrimsonNetherWartSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonNetherWartSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonNetherWartSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonNetherWartSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_crimson_nether_wart.png");
	}
}
