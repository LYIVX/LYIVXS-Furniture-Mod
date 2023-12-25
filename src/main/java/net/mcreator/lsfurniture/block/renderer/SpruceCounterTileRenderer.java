package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.SpruceCounterTileEntity;

public class SpruceCounterTileRenderer extends GeoBlockRenderer<SpruceCounterTileEntity> {
	public SpruceCounterTileRenderer() {
		super(new SpruceCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(SpruceCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
