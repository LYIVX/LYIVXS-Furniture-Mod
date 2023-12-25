package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.WarpedWardrobe1TileEntity;

public class WarpedWardrobe1BlockModel extends GeoModel<WarpedWardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedWardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_warped.png");
	}
}
