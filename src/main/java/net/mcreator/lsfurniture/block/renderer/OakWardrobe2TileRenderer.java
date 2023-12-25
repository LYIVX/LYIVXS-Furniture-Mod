package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakWardrobe2BlockModel;
import net.mcreator.lsfurniture.block.entity.OakWardrobe2TileEntity;

public class OakWardrobe2TileRenderer extends GeoBlockRenderer<OakWardrobe2TileEntity> {
	public OakWardrobe2TileRenderer() {
		super(new OakWardrobe2BlockModel());
	}

	@Override
	public RenderType getRenderType(OakWardrobe2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
