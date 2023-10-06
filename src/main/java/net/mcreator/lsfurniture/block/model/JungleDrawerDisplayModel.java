package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleDrawerDisplayItem;

public class JungleDrawerDisplayModel extends AnimatedGeoModel<JungleDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/jungle_drawer.png");
	}
}
