package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaDrawerDisplayItem;

public class AcaciaDrawerDisplayModel extends GeoModel<AcaciaDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_acacia.png");
	}
}
