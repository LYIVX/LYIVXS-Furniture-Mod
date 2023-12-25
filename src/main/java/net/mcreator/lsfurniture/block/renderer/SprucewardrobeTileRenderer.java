package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SprucewardrobeBlockModel;
import net.mcreator.lsfurniture.block.entity.SprucewardrobeTileEntity;

public class SprucewardrobeTileRenderer extends GeoBlockRenderer<SprucewardrobeTileEntity> {
	public SprucewardrobeTileRenderer() {
		super(new SprucewardrobeBlockModel());
	}

	@Override
	public RenderType getRenderType(SprucewardrobeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
