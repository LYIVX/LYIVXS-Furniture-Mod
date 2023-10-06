package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlock2TileEntity;

public class FridgeFreezerBlock2BlockModel extends AnimatedGeoModel<FridgeFreezerBlock2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlock2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/fidge_frezzer2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlock2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/fidge_frezzer2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlock2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/iron_block.png");
	}
}
