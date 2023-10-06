package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkoakDeskDisplayItem;

public class DarkoakDeskDisplayModel extends AnimatedGeoModel<DarkoakDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkoakDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkoakDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkoakDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_desk.png");
	}
}
