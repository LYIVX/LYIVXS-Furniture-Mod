package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.OakSinkTileEntity;

public class OakSinkTileRenderer extends GeoBlockRenderer<OakSinkTileEntity> {
	public OakSinkTileRenderer() {
		super(new OakSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(OakSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
