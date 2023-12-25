package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BricksOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.BricksOvenTileEntity;

public class BricksOvenTileRenderer extends GeoBlockRenderer<BricksOvenTileEntity> {
	public BricksOvenTileRenderer() {
		super(new BricksOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(BricksOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
