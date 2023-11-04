package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.display.DarkOakDeepslateSinkDisplayItem;

public class DarkOakDeepslateSinkDisplayModel extends AnimatedGeoModel<DarkOakDeepslateSinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakDeepslateSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakDeepslateSinkDisplayItem animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakDeepslateSinkDisplayItem entity) {
		return new ResourceLocation("ls_furniture", "textures/blocks/sink_dark_oak_deepslate.png");
	}
}
