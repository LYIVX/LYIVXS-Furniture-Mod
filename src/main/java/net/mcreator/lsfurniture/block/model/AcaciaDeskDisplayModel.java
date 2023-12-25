package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.AcaciaDeskDisplayItem;

public class AcaciaDeskDisplayModel extends GeoModel<AcaciaDeskDisplayItem> {
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
		return new ResourceLocation("ls_furniture", "textures/block/desk_acacia.png");
	}
}
