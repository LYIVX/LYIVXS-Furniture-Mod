package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DioriteOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.DioriteOvenTileEntity;

public class DioriteOvenTileRenderer extends GeoBlockRenderer<DioriteOvenTileEntity> {
	public DioriteOvenTileRenderer() {
		super(new DioriteOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(DioriteOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
