package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakCupboardTileEntity;

public class DarkOakCupboardBlockModel extends AnimatedGeoModel<DarkOakCupboardTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakCupboardTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/cupboard_dark_oak.png");
	}
}
