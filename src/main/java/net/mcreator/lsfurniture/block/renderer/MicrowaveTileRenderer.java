package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MicrowaveBlockModel;
import net.mcreator.lsfurniture.block.entity.MicrowaveTileEntity;

public class MicrowaveTileRenderer extends GeoBlockRenderer<MicrowaveTileEntity> {
	public MicrowaveTileRenderer() {
		super(new MicrowaveBlockModel());
	}

	@Override
	public RenderType getRenderType(MicrowaveTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
