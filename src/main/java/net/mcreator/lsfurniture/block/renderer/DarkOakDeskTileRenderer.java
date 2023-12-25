package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakDeskBlockModel;
import net.mcreator.lsfurniture.block.entity.DarkOakDeskTileEntity;

public class DarkOakDeskTileRenderer extends GeoBlockRenderer<DarkOakDeskTileEntity> {
	public DarkOakDeskTileRenderer() {
		super(new DarkOakDeskBlockModel());
	}

	@Override
	public RenderType getRenderType(DarkOakDeskTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
