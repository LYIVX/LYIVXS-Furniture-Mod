package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleWardrobe1DisplayItem;

public class JungleWardrobe1DisplayModel extends AnimatedGeoModel<JungleWardrobe1DisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_buttom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleWardrobe1DisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_buttom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleWardrobe1DisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/jungle_wardrobe.png");
	}
}
