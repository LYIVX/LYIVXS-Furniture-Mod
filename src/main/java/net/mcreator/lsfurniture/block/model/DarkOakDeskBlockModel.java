package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakDeskTileEntity;

public class DarkOakDeskBlockModel extends GeoModel<DarkOakDeskTileEntity> {
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
		return new ResourceLocation("ls_furniture", "textures/block/desk_dark_oak.png");
	}
}
