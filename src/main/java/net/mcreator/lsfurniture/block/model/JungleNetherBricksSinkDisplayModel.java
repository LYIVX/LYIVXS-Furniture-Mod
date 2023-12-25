package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleNetherBricksSinkDisplayItem;

public class JungleNetherBricksSinkDisplayModel extends GeoModel<JungleNetherBricksSinkDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/sink_jungle_nether_bricks.png");
	}
}
