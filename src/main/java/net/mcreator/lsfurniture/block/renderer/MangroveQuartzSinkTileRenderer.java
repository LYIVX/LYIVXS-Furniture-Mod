package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveQuartzSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveQuartzSinkTileEntity;

public class MangroveQuartzSinkTileRenderer extends GeoBlockRenderer<MangroveQuartzSinkTileEntity> {
	public MangroveQuartzSinkTileRenderer() {
		super(new MangroveQuartzSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveQuartzSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
