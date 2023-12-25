package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaWardrobe1TileEntity;

public class AcaciaWardrobe1BlockModel extends GeoModel<AcaciaWardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaWardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_acacia.png");
	}
}
