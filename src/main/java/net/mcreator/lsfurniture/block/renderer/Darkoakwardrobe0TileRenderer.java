package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.Darkoakwardrobe0BlockModel;
import net.mcreator.lsfurniture.block.entity.Darkoakwardrobe0TileEntity;

public class Darkoakwardrobe0TileRenderer extends GeoBlockRenderer<Darkoakwardrobe0TileEntity> {
	public Darkoakwardrobe0TileRenderer() {
		super(new Darkoakwardrobe0BlockModel());
	}

	@Override
	public RenderType getRenderType(Darkoakwardrobe0TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
