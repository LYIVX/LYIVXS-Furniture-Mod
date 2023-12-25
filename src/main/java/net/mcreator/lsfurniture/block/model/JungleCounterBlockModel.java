package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleCounterTileEntity;

public class JungleCounterBlockModel extends GeoModel<JungleCounterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleCounterTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleCounterTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/counter_jungle.png");
	}
}
