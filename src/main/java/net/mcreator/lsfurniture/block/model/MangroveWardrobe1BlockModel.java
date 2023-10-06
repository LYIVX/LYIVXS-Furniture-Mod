package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveWardrobe1TileEntity;

public class MangroveWardrobe1BlockModel extends AnimatedGeoModel<MangroveWardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_buttom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_buttom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveWardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/mangrove_wardrobe.png");
	}
}
