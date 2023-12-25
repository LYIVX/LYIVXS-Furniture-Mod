package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceDrawerDisplayItem;

public class SpruceDrawerDisplayModel extends GeoModel<SpruceDrawerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceDrawerDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceDrawerDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/drawer_spruce.png");
	}
}
