package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakDeskBlockModel;
import net.mcreator.lsfurniture.block.entity.OakDeskTileEntity;

public class OakDeskTileRenderer extends GeoBlockRenderer<OakDeskTileEntity> {
	public OakDeskTileRenderer() {
		super(new OakDeskBlockModel());
	}

	@Override
	public RenderType getRenderType(OakDeskTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
