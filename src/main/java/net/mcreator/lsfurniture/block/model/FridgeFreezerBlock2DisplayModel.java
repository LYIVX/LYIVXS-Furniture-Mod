package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.FridgeFreezerBlock2DisplayItem;

public class FridgeFreezerBlock2DisplayModel extends GeoModel<FridgeFreezerBlock2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlock2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/fridge_frezzer_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlock2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/fridge_frezzer_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlock2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/iron_block.png");
	}
}
