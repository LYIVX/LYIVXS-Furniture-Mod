package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWardrobe1BlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedWardrobe1TileEntity;

public class WarpedWardrobe1TileRenderer extends GeoBlockRenderer<WarpedWardrobe1TileEntity> {
	public WarpedWardrobe1TileRenderer() {
		super(new WarpedWardrobe1BlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedWardrobe1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
