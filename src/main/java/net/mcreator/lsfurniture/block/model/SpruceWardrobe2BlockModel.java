package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceWardrobe2TileEntity;

public class SpruceWardrobe2BlockModel extends AnimatedGeoModel<SpruceWardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceWardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_spruce.png");
	}
}
