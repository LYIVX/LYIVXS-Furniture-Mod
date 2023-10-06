package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.SpruceDrawerTileEntity;

public class SpruceDrawerBlockModel extends AnimatedGeoModel<SpruceDrawerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpruceDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/bed_side_draw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpruceDrawerTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/bed_side_draw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpruceDrawerTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/spruce_drawer.png");
	}
}
