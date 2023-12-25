package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.NetherWartOvenDisplayItem;

public class NetherWartOvenDisplayModel extends GeoModel<NetherWartOvenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(NetherWartOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/oven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NetherWartOvenDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/oven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NetherWartOvenDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/oven_nether_wart.png");
	}
}
