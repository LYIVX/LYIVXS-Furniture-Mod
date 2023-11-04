package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleCupboardTileEntity;

public class JungleCupboardBlockModel extends AnimatedGeoModel<JungleCupboardTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleCupboardTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/cupboard_jungle.png");
	}
}
