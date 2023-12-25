package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveDeskBlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveDeskTileEntity;

public class MangroveDeskTileRenderer extends GeoBlockRenderer<MangroveDeskTileEntity> {
	public MangroveDeskTileRenderer() {
		super(new MangroveDeskBlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveDeskTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
