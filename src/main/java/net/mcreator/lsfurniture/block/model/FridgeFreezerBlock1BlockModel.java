package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlock1TileEntity;

public class FridgeFreezerBlock1BlockModel extends GeoModel<FridgeFreezerBlock1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlock1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/fridge_frezzer_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlock1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/fridge_frezzer_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlock1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/iron_block.png");
	}
}
