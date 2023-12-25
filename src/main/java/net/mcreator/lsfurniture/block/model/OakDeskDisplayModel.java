package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakDeskDisplayItem;

public class OakDeskDisplayModel extends GeoModel<OakDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/desk_oak.png");
	}
}
