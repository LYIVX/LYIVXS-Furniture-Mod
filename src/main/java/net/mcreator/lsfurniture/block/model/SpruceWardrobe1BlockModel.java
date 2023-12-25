package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceWardrobe1TileEntity;

public class SpruceWardrobe1BlockModel extends GeoModel<SpruceWardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceWardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_spruce.png");
	}
}
