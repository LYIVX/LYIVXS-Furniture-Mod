package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaDeskTileEntity;

public class AcaciaDeskBlockModel extends GeoModel<AcaciaDeskTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaDeskTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaDeskTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/desk_acacia.png");
	}
}
