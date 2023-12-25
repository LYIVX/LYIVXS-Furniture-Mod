package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchWardrobe2BlockModel;
import net.mcreator.lsfurniture.block.entity.BirchWardrobe2TileEntity;

public class BirchWardrobe2TileRenderer extends GeoBlockRenderer<BirchWardrobe2TileEntity> {
	public BirchWardrobe2TileRenderer() {
		super(new BirchWardrobe2BlockModel());
	}

	@Override
	public RenderType getRenderType(BirchWardrobe2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
