package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakWardrobe1BlockModel;
import net.mcreator.lsfurniture.block.entity.OakWardrobe1TileEntity;

public class OakWardrobe1TileRenderer extends GeoBlockRenderer<OakWardrobe1TileEntity> {
	public OakWardrobe1TileRenderer() {
		super(new OakWardrobe1BlockModel());
	}

	@Override
	public RenderType getRenderType(OakWardrobe1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
