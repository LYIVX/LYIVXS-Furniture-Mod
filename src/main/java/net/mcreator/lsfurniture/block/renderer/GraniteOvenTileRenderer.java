package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.GraniteOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.GraniteOvenTileEntity;

public class GraniteOvenTileRenderer extends GeoBlockRenderer<GraniteOvenTileEntity> {
	public GraniteOvenTileRenderer() {
		super(new GraniteOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(GraniteOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
