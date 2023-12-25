package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AndesiteOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.AndesiteOvenTileEntity;

public class AndesiteOvenTileRenderer extends GeoBlockRenderer<AndesiteOvenTileEntity> {
	public AndesiteOvenTileRenderer() {
		super(new AndesiteOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(AndesiteOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
