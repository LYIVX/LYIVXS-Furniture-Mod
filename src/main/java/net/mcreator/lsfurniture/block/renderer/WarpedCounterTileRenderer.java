package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedCounterTileEntity;

public class WarpedCounterTileRenderer extends GeoBlockRenderer<WarpedCounterTileEntity> {
	public WarpedCounterTileRenderer() {
		super(new WarpedCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
