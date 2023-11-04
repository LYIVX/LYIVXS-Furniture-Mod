package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakDeskDisplayItem;

public class DarkOakDeskDisplayModel extends AnimatedGeoModel<DarkOakDeskDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/desk_dark_oak.png");
	}
}
