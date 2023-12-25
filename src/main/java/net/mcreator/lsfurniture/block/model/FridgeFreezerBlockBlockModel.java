package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlockTileEntity;

public class FridgeFreezerBlockBlockModel extends GeoModel<FridgeFreezerBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlockTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/fridge_frezzer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlockTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/fridge_frezzer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlockTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/iron_block.png");
	}
}
