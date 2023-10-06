package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.OakDrawerDisplayItem;

public class OakDrawerDisplayModel extends AnimatedGeoModel<OakDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OakDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/oak_drawer.png");
	}
}
