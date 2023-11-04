package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleWardrobe2DisplayItem;

public class JungleWardrobe2DisplayModel extends AnimatedGeoModel<JungleWardrobe2DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleWardrobe2DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleWardrobe2DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_jungle.png");
	}
}
