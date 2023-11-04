package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleDrawerDisplayItem;

public class JungleDrawerDisplayModel extends AnimatedGeoModel<JungleDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/drawer_jungle.png");
	}
}
