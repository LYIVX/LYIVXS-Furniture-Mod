package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MangroveDrawerDisplayItem;

public class MangroveDrawerDisplayModel extends AnimatedGeoModel<MangroveDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MangroveDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/drawer_mangrove.png");
	}
}
