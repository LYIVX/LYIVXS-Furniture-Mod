package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakWardrobe0BlockModel;
import net.mcreator.lsfurniture.block.entity.OakWardrobe0TileEntity;

public class OakWardrobe0TileRenderer extends GeoBlockRenderer<OakWardrobe0TileEntity> {
	public OakWardrobe0TileRenderer() {
		super(new OakWardrobe0BlockModel());
	}

	@Override
	public RenderType getRenderType(OakWardrobe0TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
