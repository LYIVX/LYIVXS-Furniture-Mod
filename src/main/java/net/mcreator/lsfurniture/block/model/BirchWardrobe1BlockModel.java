package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.BirchWardrobe1TileEntity;

public class BirchWardrobe1BlockModel extends AnimatedGeoModel<BirchWardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BirchWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_buttom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BirchWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_buttom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BirchWardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/birch_wardrobe.png");
	}
}
