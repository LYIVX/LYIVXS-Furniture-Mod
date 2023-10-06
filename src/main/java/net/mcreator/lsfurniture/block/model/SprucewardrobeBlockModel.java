package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SprucewardrobeTileEntity;

public class SprucewardrobeBlockModel extends AnimatedGeoModel<SprucewardrobeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SprucewardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SprucewardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SprucewardrobeTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/spruce_wardrobe.png");
	}
}
