package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleCupboardDisplayItem;

public class JungleCupboardDisplayModel extends GeoModel<JungleCupboardDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleCupboardDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/cupboard_jungle.png");
	}
}
