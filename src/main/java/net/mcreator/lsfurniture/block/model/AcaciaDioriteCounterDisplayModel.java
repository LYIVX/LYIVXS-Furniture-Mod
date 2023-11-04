package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaDioriteCounterDisplayItem;

public class AcaciaDioriteCounterDisplayModel extends AnimatedGeoModel<AcaciaDioriteCounterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaDioriteCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/counter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaDioriteCounterDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/counter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaDioriteCounterDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/counter_acacia_diorite.png");
	}
}
