package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveOvenTileEntity;

public class MangroveOvenTileRenderer extends GeoBlockRenderer<MangroveOvenTileEntity> {
	public MangroveOvenTileRenderer() {
		super(new MangroveOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
