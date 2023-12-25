package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveWardrobe2BlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveWardrobe2TileEntity;

public class MangroveWardrobe2TileRenderer extends GeoBlockRenderer<MangroveWardrobe2TileEntity> {
	public MangroveWardrobe2TileRenderer() {
		super(new MangroveWardrobe2BlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveWardrobe2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
