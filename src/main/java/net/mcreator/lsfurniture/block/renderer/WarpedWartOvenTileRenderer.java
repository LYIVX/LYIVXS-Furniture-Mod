package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWartOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedWartOvenTileEntity;

public class WarpedWartOvenTileRenderer extends GeoBlockRenderer<WarpedWartOvenTileEntity> {
	public WarpedWartOvenTileRenderer() {
		super(new WarpedWartOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedWartOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
