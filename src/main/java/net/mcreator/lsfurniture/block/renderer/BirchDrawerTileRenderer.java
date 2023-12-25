package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchDrawerBlockModel;
import net.mcreator.lsfurniture.block.entity.BirchDrawerTileEntity;

public class BirchDrawerTileRenderer extends GeoBlockRenderer<BirchDrawerTileEntity> {
	public BirchDrawerTileRenderer() {
		super(new BirchDrawerBlockModel());
	}

	@Override
	public RenderType getRenderType(BirchDrawerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
