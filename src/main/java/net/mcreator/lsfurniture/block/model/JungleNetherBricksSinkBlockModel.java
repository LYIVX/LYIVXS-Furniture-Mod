package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleNetherBricksSinkTileEntity;

public class JungleNetherBricksSinkBlockModel extends GeoModel<JungleNetherBricksSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleNetherBricksSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleNetherBricksSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleNetherBricksSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_jungle_nether_bricks.png");
	}
}
