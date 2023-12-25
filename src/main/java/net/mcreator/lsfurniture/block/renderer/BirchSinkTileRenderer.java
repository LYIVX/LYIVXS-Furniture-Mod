package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.BirchSinkTileEntity;

public class BirchSinkTileRenderer extends GeoBlockRenderer<BirchSinkTileEntity> {
	public BirchSinkTileRenderer() {
		super(new BirchSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(BirchSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
