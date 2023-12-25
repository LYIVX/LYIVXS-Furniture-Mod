package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.SpruceWardrobe1DisplayItem;

public class SpruceWardrobe1DisplayModel extends GeoModel<SpruceWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SpruceWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_spruce.png");
	}
}
