package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.BirchCounterTileEntity;

public class BirchCounterTileRenderer extends GeoBlockRenderer<BirchCounterTileEntity> {
	public BirchCounterTileRenderer() {
		super(new BirchCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(BirchCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
