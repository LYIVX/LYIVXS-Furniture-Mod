package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakDrawerDisplayItem;

public class DarkOakDrawerDisplayModel extends AnimatedGeoModel<DarkOakDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_drawer.png");
	}
}
