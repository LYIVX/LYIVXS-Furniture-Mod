package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakWardrobe0TileEntity;

public class OakWardrobe0BlockModel extends GeoModel<OakWardrobe0TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakWardrobe0TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakWardrobe0TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakWardrobe0TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_oak.png");
	}
}
