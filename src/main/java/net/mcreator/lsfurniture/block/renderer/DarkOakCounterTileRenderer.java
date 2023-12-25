package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.DarkOakCounterTileEntity;

public class DarkOakCounterTileRenderer extends GeoBlockRenderer<DarkOakCounterTileEntity> {
	public DarkOakCounterTileRenderer() {
		super(new DarkOakCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(DarkOakCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
