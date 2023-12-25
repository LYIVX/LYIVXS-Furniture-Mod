package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.JungleDeskDisplayItem;

public class JungleDeskDisplayModel extends GeoModel<JungleDeskDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JungleDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/desk.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JungleDeskDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/desk.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JungleDeskDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/block/desk_jungle.png");
	}
}
