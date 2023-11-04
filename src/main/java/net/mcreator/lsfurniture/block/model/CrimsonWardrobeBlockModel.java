package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonWardrobeTileEntity;

public class CrimsonWardrobeBlockModel extends AnimatedGeoModel<CrimsonWardrobeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonWardrobeTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_crimson.png");
	}
}
