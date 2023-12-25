package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleSinkDisplayItem;

public class JungleSinkDisplayModel extends GeoModel<JungleSinkDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/sink_jungle.png");
	}
}
