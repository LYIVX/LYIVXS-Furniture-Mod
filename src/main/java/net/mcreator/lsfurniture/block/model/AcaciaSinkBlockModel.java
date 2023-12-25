package net.mcreator.lsfurniture.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.block.entity.AcaciaSinkTileEntity;

public class AcaciaSinkBlockModel extends GeoModel<AcaciaSinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcaciaSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "animations/sink.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcaciaSinkTileEntity animatable) {
		return new ResourceLocation("ls_furniture", "geo/sink.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcaciaSinkTileEntity entity) {
		return new ResourceLocation("ls_furniture", "textures/block/sink_acacia.png");
	}
}
