package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleWardrobeDisplayItem;

public class JungleWardrobeDisplayModel extends GeoModel<JungleWardrobeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleWardrobeDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleWardrobeDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_jungle.png");
	}
}
