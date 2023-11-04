package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.Darkoakwardrobe1TileEntity;

public class Darkoakwardrobe1BlockModel extends AnimatedGeoModel<Darkoakwardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(Darkoakwardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Darkoakwardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Darkoakwardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_dark_oak.png");
	}
}
