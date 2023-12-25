package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonDrawerBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonDrawerTileEntity;

public class CrimsonDrawerTileRenderer extends GeoBlockRenderer<CrimsonDrawerTileEntity> {
	public CrimsonDrawerTileRenderer() {
		super(new CrimsonDrawerBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonDrawerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
