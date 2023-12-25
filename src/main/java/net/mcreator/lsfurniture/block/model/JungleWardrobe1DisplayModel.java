package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleWardrobe1DisplayItem;

public class JungleWardrobe1DisplayModel extends GeoModel<JungleWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_jungle.png");
	}
}
