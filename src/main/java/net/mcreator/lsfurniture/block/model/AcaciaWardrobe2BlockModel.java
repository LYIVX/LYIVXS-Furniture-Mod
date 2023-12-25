package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaWardrobe2TileEntity;

public class AcaciaWardrobe2BlockModel extends GeoModel<AcaciaWardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaWardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_acacia.png");
	}
}
