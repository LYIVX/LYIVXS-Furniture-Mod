package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakDrawerBlockModel;
import net.mcreator.lsfurniture.block.entity.OakDrawerTileEntity;

public class OakDrawerTileRenderer extends GeoBlockRenderer<OakDrawerTileEntity> {
	public OakDrawerTileRenderer() {
		super(new OakDrawerBlockModel());
	}

	@Override
	public RenderType getRenderType(OakDrawerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
