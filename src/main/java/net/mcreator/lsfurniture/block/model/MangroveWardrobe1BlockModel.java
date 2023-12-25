package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.MangroveWardrobe1TileEntity;

public class MangroveWardrobe1BlockModel extends GeoModel<MangroveWardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MangroveWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MangroveWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MangroveWardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_mangrove.png");
	}
}
