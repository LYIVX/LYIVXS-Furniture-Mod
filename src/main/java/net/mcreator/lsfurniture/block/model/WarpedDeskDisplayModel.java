package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedDeskDisplayItem;

public class WarpedDeskDisplayModel extends AnimatedGeoModel<WarpedDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/desk_warped.png");
	}
}
