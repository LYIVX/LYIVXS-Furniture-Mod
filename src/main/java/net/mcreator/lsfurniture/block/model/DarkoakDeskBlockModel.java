package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkoakDeskTileEntity;

public class DarkoakDeskBlockModel extends AnimatedGeoModel<DarkoakDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkoakDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkoakDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkoakDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/dark_oak_desk.png");
	}
}
