package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedDrawerBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedDrawerTileEntity;

public class WarpedDrawerTileRenderer extends GeoBlockRenderer<WarpedDrawerTileEntity> {
	public WarpedDrawerTileRenderer() {
		super(new WarpedDrawerBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedDrawerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
