package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonSinkTileEntity;

public class CrimsonSinkTileRenderer extends GeoBlockRenderer<CrimsonSinkTileEntity> {
	public CrimsonSinkTileRenderer() {
		super(new CrimsonSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
