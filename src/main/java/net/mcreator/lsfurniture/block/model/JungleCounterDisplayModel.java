package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleCounterDisplayItem;

public class JungleCounterDisplayModel extends GeoModel<JungleCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_jungle.png");
	}
}
