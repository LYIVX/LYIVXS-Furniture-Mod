package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.OakWardrobe1TileEntity;

public class OakWardrobe1BlockModel extends AnimatedGeoModel<OakWardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OakWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OakWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OakWardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_oak.png");
	}
}
