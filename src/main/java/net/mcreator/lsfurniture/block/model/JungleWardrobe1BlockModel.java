package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.JungleWardrobe1TileEntity;

public class JungleWardrobe1BlockModel extends AnimatedGeoModel<JungleWardrobe1TileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JungleWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/wardrobe_bottom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleWardrobe1TileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/wardrobe_bottom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleWardrobe1TileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/wardrobe_jungle.png");
	}
}
