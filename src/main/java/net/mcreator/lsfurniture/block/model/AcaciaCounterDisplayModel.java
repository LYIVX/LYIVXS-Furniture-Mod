package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaCounterDisplayItem;

public class AcaciaCounterDisplayModel extends GeoModel<AcaciaCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_acacia.png");
	}
}
