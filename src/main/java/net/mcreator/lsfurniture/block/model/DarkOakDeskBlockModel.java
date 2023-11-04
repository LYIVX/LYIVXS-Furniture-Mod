package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakDeskTileEntity;

public class DarkOakDeskBlockModel extends AnimatedGeoModel<DarkOakDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/desk_dark_oak.png");
	}
}
