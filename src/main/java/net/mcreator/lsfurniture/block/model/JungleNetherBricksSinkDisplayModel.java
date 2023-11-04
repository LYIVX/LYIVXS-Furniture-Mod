package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleNetherBricksSinkDisplayItem;

public class JungleNetherBricksSinkDisplayModel extends AnimatedGeoModel<JungleNetherBricksSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleNetherBricksSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleNetherBricksSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleNetherBricksSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_jungle_nether_bricks.png");
	}
}
