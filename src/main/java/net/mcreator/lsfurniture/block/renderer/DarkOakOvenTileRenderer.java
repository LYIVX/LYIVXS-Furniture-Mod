package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.DarkOakOvenTileEntity;

public class DarkOakOvenTileRenderer extends GeoBlockRenderer<DarkOakOvenTileEntity> {
	public DarkOakOvenTileRenderer() {
		super(new DarkOakOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(DarkOakOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
