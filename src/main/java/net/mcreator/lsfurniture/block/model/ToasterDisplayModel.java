package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.ToasterDisplayItem;

public class ToasterDisplayModel extends GeoModel<ToasterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ToasterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/toaster.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ToasterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/toaster.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ToasterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/toaster.png");
	}
}
