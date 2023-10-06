package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlock1TileEntity;

public class FridgeFreezerBlock1BlockModel extends AnimatedGeoModel<FridgeFreezerBlock1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlock1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/fidge_frezzer_1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlock1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/fidge_frezzer_1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlock1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/iron_block.png");
	}
}
