package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedOvenTileEntity;

public class WarpedOvenTileRenderer extends GeoBlockRenderer<WarpedOvenTileEntity> {
	public WarpedOvenTileRenderer() {
		super(new WarpedOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
