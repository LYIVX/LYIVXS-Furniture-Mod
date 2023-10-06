package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlockTileEntity;

public class FridgeFreezerBlockBlockModel extends AnimatedGeoModel<FridgeFreezerBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlockTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/fidge_frezzer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlockTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/fidge_frezzer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlockTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/iron_block.png");
	}
}
