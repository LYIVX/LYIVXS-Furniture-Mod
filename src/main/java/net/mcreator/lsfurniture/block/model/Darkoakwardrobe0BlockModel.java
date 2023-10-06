package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.Darkoakwardrobe0TileEntity;

public class Darkoakwardrobe0BlockModel extends AnimatedGeoModel<Darkoakwardrobe0TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(Darkoakwardrobe0TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Darkoakwardrobe0TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Darkoakwardrobe0TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_wardrobe.png");
	}
}
