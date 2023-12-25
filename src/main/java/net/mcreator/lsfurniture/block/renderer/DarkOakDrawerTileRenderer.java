package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakDrawerBlockModel;
import net.mcreator.lsfurniture.block.entity.DarkOakDrawerTileEntity;

public class DarkOakDrawerTileRenderer extends GeoBlockRenderer<DarkOakDrawerTileEntity> {
	public DarkOakDrawerTileRenderer() {
		super(new DarkOakDrawerBlockModel());
	}

	@Override
	public RenderType getRenderType(DarkOakDrawerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
