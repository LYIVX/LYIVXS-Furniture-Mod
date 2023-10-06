package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonDrawerTileEntity;

public class CrimsonDrawerBlockModel extends AnimatedGeoModel<CrimsonDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/crimson_drawer.png");
	}
}
