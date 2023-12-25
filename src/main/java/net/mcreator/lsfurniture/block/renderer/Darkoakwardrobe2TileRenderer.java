package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.Darkoakwardrobe2BlockModel;
import net.mcreator.lsfurniture.block.entity.Darkoakwardrobe2TileEntity;

public class Darkoakwardrobe2TileRenderer extends GeoBlockRenderer<Darkoakwardrobe2TileEntity> {
	public Darkoakwardrobe2TileRenderer() {
		super(new Darkoakwardrobe2BlockModel());
	}

	@Override
	public RenderType getRenderType(Darkoakwardrobe2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
