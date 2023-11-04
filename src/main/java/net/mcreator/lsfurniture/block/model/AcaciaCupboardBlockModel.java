package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaCupboardTileEntity;

public class AcaciaCupboardBlockModel extends AnimatedGeoModel<AcaciaCupboardTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaCupboardTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaCupboardTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/cupboard_acacia.png");
	}
}
