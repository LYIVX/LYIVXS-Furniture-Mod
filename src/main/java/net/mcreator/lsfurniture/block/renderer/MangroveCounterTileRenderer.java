package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveCounterTileEntity;

public class MangroveCounterTileRenderer extends GeoBlockRenderer<MangroveCounterTileEntity> {
	public MangroveCounterTileRenderer() {
		super(new MangroveCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
