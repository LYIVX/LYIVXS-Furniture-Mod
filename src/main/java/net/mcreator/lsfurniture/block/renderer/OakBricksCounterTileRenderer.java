package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakBricksCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.OakBricksCounterTileEntity;

public class OakBricksCounterTileRenderer extends GeoBlockRenderer<OakBricksCounterTileEntity> {
	public OakBricksCounterTileRenderer() {
		super(new OakBricksCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(OakBricksCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
