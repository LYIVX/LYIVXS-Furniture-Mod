package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.FurnitureCrafterBetaTileEntity;

public class FurnitureCrafterBetaBlockModel extends AnimatedGeoModel<FurnitureCrafterBetaTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(FurnitureCrafterBetaTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/furniture_crafter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FurnitureCrafterBetaTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/furniture_crafter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FurnitureCrafterBetaTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/furniture_crafter.png");
	}
}
