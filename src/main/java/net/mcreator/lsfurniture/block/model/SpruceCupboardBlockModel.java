package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceCupboardTileEntity;

public class SpruceCupboardBlockModel extends AnimatedGeoModel<SpruceCupboardTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceCupboardTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/spruce_cupboard.png");
	}
}
