package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaWardrobe2BlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaWardrobe2TileEntity;

public class AcaciaWardrobe2TileRenderer extends GeoBlockRenderer<AcaciaWardrobe2TileEntity> {
	public AcaciaWardrobe2TileRenderer() {
		super(new AcaciaWardrobe2BlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaWardrobe2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
