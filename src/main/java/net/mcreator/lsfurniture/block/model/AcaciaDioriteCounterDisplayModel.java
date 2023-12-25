package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaDioriteCounterDisplayItem;

public class AcaciaDioriteCounterDisplayModel extends GeoModel<AcaciaDioriteCounterDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/counter_acacia_diorite.png");
	}
}
