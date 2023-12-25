package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWardrobe2BlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedWardrobe2TileEntity;

public class WarpedWardrobe2TileRenderer extends GeoBlockRenderer<WarpedWardrobe2TileEntity> {
	public WarpedWardrobe2TileRenderer() {
		super(new WarpedWardrobe2BlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedWardrobe2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
