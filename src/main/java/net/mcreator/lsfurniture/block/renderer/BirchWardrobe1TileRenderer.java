package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchWardrobe1BlockModel;
import net.mcreator.lsfurniture.block.entity.BirchWardrobe1TileEntity;

public class BirchWardrobe1TileRenderer extends GeoBlockRenderer<BirchWardrobe1TileEntity> {
	public BirchWardrobe1TileRenderer() {
		super(new BirchWardrobe1BlockModel());
	}

	@Override
	public RenderType getRenderType(BirchWardrobe1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
