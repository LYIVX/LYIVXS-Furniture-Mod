package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleWardrobeTileEntity;

public class JungleWardrobeBlockModel extends GeoModel<JungleWardrobeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleWardrobeTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleWardrobeTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/wardrobe_jungle.png");
	}
}
