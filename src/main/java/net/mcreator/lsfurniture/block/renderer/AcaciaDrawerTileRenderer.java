package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaDrawerBlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaDrawerTileEntity;

public class AcaciaDrawerTileRenderer extends GeoBlockRenderer<AcaciaDrawerTileEntity> {
	public AcaciaDrawerTileRenderer() {
		super(new AcaciaDrawerBlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaDrawerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
