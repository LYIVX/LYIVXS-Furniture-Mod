package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveWardrobe2TileEntity;

public class MangroveWardrobe2BlockModel extends GeoModel<MangroveWardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveWardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_mangrove.png");
	}
}
