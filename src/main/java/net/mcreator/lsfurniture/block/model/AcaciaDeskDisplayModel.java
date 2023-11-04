package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaDeskDisplayItem;

public class AcaciaDeskDisplayModel extends AnimatedGeoModel<AcaciaDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/desk_acacia.png");
	}
}
