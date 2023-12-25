package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.DarkOakSinkTileEntity;

public class DarkOakSinkTileRenderer extends GeoBlockRenderer<DarkOakSinkTileEntity> {
	public DarkOakSinkTileRenderer() {
		super(new DarkOakSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(DarkOakSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
