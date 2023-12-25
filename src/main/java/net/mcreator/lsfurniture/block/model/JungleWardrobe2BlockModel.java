package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleWardrobe2TileEntity;

public class JungleWardrobe2BlockModel extends GeoModel<JungleWardrobe2TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_top.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleWardrobe2TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_top.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleWardrobe2TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_jungle.png");
	}
}
