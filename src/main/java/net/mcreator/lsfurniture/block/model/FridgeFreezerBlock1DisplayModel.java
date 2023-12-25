package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.FridgeFreezerBlock1DisplayItem;

public class FridgeFreezerBlock1DisplayModel extends GeoModel<FridgeFreezerBlock1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlock1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/fridge_frezzer_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlock1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/fridge_frezzer_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlock1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/iron_block.png");
	}
}
