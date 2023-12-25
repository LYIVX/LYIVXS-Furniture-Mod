package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleNetherBricksCounterDisplayItem;

public class JungleNetherBricksCounterDisplayModel extends GeoModel<JungleNetherBricksCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleNetherBricksCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleNetherBricksCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleNetherBricksCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_jungle_nether_brick.png");
	}
}
