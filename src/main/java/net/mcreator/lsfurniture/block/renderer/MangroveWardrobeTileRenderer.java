package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveWardrobeBlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveWardrobeTileEntity;

public class MangroveWardrobeTileRenderer extends GeoBlockRenderer<MangroveWardrobeTileEntity> {
	public MangroveWardrobeTileRenderer() {
		super(new MangroveWardrobeBlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveWardrobeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
