package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedDeskBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedDeskTileEntity;

public class WarpedDeskTileRenderer extends GeoBlockRenderer<WarpedDeskTileEntity> {
	public WarpedDeskTileRenderer() {
		super(new WarpedDeskBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedDeskTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
