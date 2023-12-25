package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakWardrobe2TileEntity;

public class OakWardrobe2BlockModel extends GeoModel<OakWardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakWardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_oak.png");
	}
}
