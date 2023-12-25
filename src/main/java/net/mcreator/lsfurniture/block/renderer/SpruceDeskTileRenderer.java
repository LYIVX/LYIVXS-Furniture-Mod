package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceDeskBlockModel;
import net.mcreator.lsfurniture.block.entity.SpruceDeskTileEntity;

public class SpruceDeskTileRenderer extends GeoBlockRenderer<SpruceDeskTileEntity> {
	public SpruceDeskTileRenderer() {
		super(new SpruceDeskBlockModel());
	}

	@Override
	public RenderType getRenderType(SpruceDeskTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
