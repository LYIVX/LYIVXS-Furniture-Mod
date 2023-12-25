package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaWardrobeBlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaWardrobeTileEntity;

public class AcaciaWardrobeTileRenderer extends GeoBlockRenderer<AcaciaWardrobeTileEntity> {
	public AcaciaWardrobeTileRenderer() {
		super(new AcaciaWardrobeBlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaWardrobeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
