package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonDeskBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonDeskTileEntity;

public class CrimsonDeskTileRenderer extends GeoBlockRenderer<CrimsonDeskTileEntity> {
	public CrimsonDeskTileRenderer() {
		super(new CrimsonDeskBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonDeskTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
