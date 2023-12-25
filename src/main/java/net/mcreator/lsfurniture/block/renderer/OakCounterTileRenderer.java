package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.OakCounterTileEntity;

public class OakCounterTileRenderer extends GeoBlockRenderer<OakCounterTileEntity> {
	public OakCounterTileRenderer() {
		super(new OakCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(OakCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
