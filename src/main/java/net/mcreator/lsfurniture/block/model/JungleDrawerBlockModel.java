package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleDrawerTileEntity;

public class JungleDrawerBlockModel extends AnimatedGeoModel<JungleDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/drawer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/drawer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/drawer_jungle.png");
	}
}
