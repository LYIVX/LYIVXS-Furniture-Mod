package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlock2TileEntity;

public class FridgeFreezerBlock2BlockModel extends GeoModel<FridgeFreezerBlock2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlock2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/fridge_frezzer_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlock2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/fridge_frezzer_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlock2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/iron_block.png");
	}
}
