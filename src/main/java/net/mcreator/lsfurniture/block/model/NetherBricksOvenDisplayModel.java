package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.NetherBricksOvenDisplayItem;

public class NetherBricksOvenDisplayModel extends GeoModel<NetherBricksOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(NetherBricksOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NetherBricksOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NetherBricksOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_nether_bricks.png");
	}
}
