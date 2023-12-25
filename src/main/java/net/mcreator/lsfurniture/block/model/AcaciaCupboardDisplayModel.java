package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaCupboardDisplayItem;

public class AcaciaCupboardDisplayModel extends GeoModel<AcaciaCupboardDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/cupboard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaCupboardDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/cupboard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaCupboardDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/cupboard_acacia.png");
	}
}
