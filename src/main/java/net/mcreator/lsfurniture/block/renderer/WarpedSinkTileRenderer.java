package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedSinkTileEntity;

public class WarpedSinkTileRenderer extends GeoBlockRenderer<WarpedSinkTileEntity> {
	public WarpedSinkTileRenderer() {
		super(new WarpedSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
