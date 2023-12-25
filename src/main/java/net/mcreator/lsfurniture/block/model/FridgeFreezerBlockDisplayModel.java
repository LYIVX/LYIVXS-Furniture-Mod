package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.FridgeFreezerBlockDisplayItem;

public class FridgeFreezerBlockDisplayModel extends GeoModel<FridgeFreezerBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(FridgeFreezerBlockDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/fridge_frezzer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FridgeFreezerBlockDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/fridge_frezzer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FridgeFreezerBlockDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/iron_block.png");
	}
}
