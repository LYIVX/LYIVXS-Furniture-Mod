package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveQuartzCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveQuartzCounterTileEntity;

public class MangroveQuartzCounterTileRenderer extends GeoBlockRenderer<MangroveQuartzCounterTileEntity> {
	public MangroveQuartzCounterTileRenderer() {
		super(new MangroveQuartzCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveQuartzCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
