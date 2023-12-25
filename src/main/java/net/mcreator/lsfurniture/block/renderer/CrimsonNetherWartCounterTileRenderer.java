package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonNetherWartCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonNetherWartCounterTileEntity;

public class CrimsonNetherWartCounterTileRenderer extends GeoBlockRenderer<CrimsonNetherWartCounterTileEntity> {
	public CrimsonNetherWartCounterTileRenderer() {
		super(new CrimsonNetherWartCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonNetherWartCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
