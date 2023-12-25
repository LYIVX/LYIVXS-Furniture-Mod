package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.CrimsonDeskDisplayItem;

public class CrimsonDeskDisplayModel extends GeoModel<CrimsonDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/desk_crimson.png");
	}
}
