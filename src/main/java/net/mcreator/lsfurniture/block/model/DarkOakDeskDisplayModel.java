package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakDeskDisplayItem;

public class DarkOakDeskDisplayModel extends GeoModel<DarkOakDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/desk_dark_oak.png");
	}
}
