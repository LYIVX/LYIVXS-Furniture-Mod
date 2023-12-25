package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.KettleBlockModel;
import net.mcreator.lsfurniture.block.entity.KettleTileEntity;

public class KettleTileRenderer extends GeoBlockRenderer<KettleTileEntity> {
	public KettleTileRenderer() {
		super(new KettleBlockModel());
	}

	@Override
	public RenderType getRenderType(KettleTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
