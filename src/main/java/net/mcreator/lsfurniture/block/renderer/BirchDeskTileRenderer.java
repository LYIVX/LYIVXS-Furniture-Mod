package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchDeskBlockModel;
import net.mcreator.lsfurniture.block.entity.BirchDeskTileEntity;

public class BirchDeskTileRenderer extends GeoBlockRenderer<BirchDeskTileEntity> {
	public BirchDeskTileRenderer() {
		super(new BirchDeskBlockModel());
	}

	@Override
	public RenderType getRenderType(BirchDeskTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
