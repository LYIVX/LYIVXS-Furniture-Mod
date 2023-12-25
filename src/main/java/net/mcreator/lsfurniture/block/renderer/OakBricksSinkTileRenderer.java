package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakBricksSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.OakBricksSinkTileEntity;

public class OakBricksSinkTileRenderer extends GeoBlockRenderer<OakBricksSinkTileEntity> {
	public OakBricksSinkTileRenderer() {
		super(new OakBricksSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(OakBricksSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
