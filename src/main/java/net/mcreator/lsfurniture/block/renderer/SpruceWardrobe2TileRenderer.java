package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceWardrobe2BlockModel;
import net.mcreator.lsfurniture.block.entity.SpruceWardrobe2TileEntity;

public class SpruceWardrobe2TileRenderer extends GeoBlockRenderer<SpruceWardrobe2TileEntity> {
	public SpruceWardrobe2TileRenderer() {
		super(new SpruceWardrobe2BlockModel());
	}

	@Override
	public RenderType getRenderType(SpruceWardrobe2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
