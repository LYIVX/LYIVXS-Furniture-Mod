package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleNetherBricksCounterTileEntity;

public class JungleNetherBricksCounterBlockModel extends GeoModel<JungleNetherBricksCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleNetherBricksCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleNetherBricksCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleNetherBricksCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_jungle_nether_brick.png");
	}
}
