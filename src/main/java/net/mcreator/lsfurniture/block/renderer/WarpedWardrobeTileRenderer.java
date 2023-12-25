package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWardrobeBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedWardrobeTileEntity;

public class WarpedWardrobeTileRenderer extends GeoBlockRenderer<WarpedWardrobeTileEntity> {
	public WarpedWardrobeTileRenderer() {
		super(new WarpedWardrobeBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedWardrobeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
