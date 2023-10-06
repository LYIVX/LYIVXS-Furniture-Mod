package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.WarpedDrawerDisplayItem;

public class WarpedDrawerDisplayModel extends AnimatedGeoModel<WarpedDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WarpedDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/warped_drawer.png");
	}
}
