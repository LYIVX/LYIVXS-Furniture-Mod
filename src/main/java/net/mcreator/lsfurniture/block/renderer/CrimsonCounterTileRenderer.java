package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonCounterTileEntity;

public class CrimsonCounterTileRenderer extends GeoBlockRenderer<CrimsonCounterTileEntity> {
	public CrimsonCounterTileRenderer() {
		super(new CrimsonCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
