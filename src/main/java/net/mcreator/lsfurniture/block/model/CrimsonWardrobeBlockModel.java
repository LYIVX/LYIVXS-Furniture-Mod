package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonWardrobeTileEntity;

public class CrimsonWardrobeBlockModel extends GeoModel<CrimsonWardrobeTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_crimson.png");
	}
}
