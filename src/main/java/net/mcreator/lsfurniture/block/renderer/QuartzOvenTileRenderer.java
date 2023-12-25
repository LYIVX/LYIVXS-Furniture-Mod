package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.QuartzOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.QuartzOvenTileEntity;

public class QuartzOvenTileRenderer extends GeoBlockRenderer<QuartzOvenTileEntity> {
	public QuartzOvenTileRenderer() {
		super(new QuartzOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(QuartzOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
