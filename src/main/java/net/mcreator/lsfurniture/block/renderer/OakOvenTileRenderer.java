package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.OakOvenTileEntity;

public class OakOvenTileRenderer extends GeoBlockRenderer<OakOvenTileEntity> {
	public OakOvenTileRenderer() {
		super(new OakOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(OakOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
