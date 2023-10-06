package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.CrimsonWardrobe1TileEntity;

public class CrimsonWardrobe1BlockModel extends AnimatedGeoModel<CrimsonWardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_buttom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_buttom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonWardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/crimson_wardrobe.png");
	}
}
