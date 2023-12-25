package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchGraniteCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.BirchGraniteCounterTileEntity;

public class BirchGraniteCounterTileRenderer extends GeoBlockRenderer<BirchGraniteCounterTileEntity> {
	public BirchGraniteCounterTileRenderer() {
		super(new BirchGraniteCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(BirchGraniteCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
