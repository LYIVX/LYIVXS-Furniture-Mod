package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.DarkOakDeepslateSinkTileEntity;

public class DarkOakDeepslateSinkBlockModel extends GeoModel<DarkOakDeepslateSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkOakDeepslateSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkOakDeepslateSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkOakDeepslateSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_dark_oak_deepslate.png");
	}
}
