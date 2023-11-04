package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaDioriteSinkDisplayItem;

public class AcaciaDioriteSinkDisplayModel extends AnimatedGeoModel<AcaciaDioriteSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaDioriteSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaDioriteSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaDioriteSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_acacia_diorite.png");
	}
}
