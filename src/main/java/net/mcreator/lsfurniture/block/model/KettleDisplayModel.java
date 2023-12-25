package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.KettleDisplayItem;

public class KettleDisplayModel extends GeoModel<KettleDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(KettleDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/kettle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KettleDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/kettle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KettleDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/kettle.png");
	}
}
