package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveSinkTileEntity;

public class MangroveSinkTileRenderer extends GeoBlockRenderer<MangroveSinkTileEntity> {
	public MangroveSinkTileRenderer() {
		super(new MangroveSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
