package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleDeskTileEntity;

public class JungleDeskBlockModel extends GeoModel<JungleDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/desk_jungle.png");
	}
}
