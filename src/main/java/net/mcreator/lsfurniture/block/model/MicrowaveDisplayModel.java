package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.MicrowaveDisplayItem;

public class MicrowaveDisplayModel extends GeoModel<MicrowaveDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MicrowaveDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/microwave.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MicrowaveDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/microwave.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MicrowaveDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/microwave.png");
	}
}
