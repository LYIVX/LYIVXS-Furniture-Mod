package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaWardrobeTileEntity;

public class AcaciaWardrobeBlockModel extends GeoModel<AcaciaWardrobeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaWardrobeTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_acacia.png");
	}
}
