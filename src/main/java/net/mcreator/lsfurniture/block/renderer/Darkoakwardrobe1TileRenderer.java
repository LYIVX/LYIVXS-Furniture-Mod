package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.Darkoakwardrobe1BlockModel;
import net.mcreator.lsfurniture.block.entity.Darkoakwardrobe1TileEntity;

public class Darkoakwardrobe1TileRenderer extends GeoBlockRenderer<Darkoakwardrobe1TileEntity> {
	public Darkoakwardrobe1TileRenderer() {
		super(new Darkoakwardrobe1BlockModel());
	}

	@Override
	public RenderType getRenderType(Darkoakwardrobe1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
