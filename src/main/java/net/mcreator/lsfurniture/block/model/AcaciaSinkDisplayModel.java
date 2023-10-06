package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaSinkDisplayItem;

public class AcaciaSinkDisplayModel extends AnimatedGeoModel<AcaciaSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/acacia_sink.png");
	}
}
