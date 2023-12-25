package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonNetherWartSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonNetherWartSinkTileEntity;

public class CrimsonNetherWartSinkTileRenderer extends GeoBlockRenderer<CrimsonNetherWartSinkTileEntity> {
	public CrimsonNetherWartSinkTileRenderer() {
		super(new CrimsonNetherWartSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonNetherWartSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
