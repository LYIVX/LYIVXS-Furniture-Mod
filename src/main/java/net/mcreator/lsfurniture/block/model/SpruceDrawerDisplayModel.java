package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceDrawerDisplayItem;

public class SpruceDrawerDisplayModel extends AnimatedGeoModel<SpruceDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/spruce_drawer.png");
	}
}
