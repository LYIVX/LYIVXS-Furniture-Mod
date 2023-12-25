package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveDrawerBlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveDrawerTileEntity;

public class MangroveDrawerTileRenderer extends GeoBlockRenderer<MangroveDrawerTileEntity> {
	public MangroveDrawerTileRenderer() {
		super(new MangroveDrawerBlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveDrawerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
