package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaOvenTileEntity;

public class AcaciaOvenTileRenderer extends GeoBlockRenderer<AcaciaOvenTileEntity> {
	public AcaciaOvenTileRenderer() {
		super(new AcaciaOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
