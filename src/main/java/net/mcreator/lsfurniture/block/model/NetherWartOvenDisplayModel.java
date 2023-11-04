package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.NetherWartOvenDisplayItem;

public class NetherWartOvenDisplayModel extends AnimatedGeoModel<NetherWartOvenDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/blocks/oven_nether_wart.png");
	}
}
