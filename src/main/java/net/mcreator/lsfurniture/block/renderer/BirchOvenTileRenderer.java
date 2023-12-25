package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.BirchOvenTileEntity;

public class BirchOvenTileRenderer extends GeoBlockRenderer<BirchOvenTileEntity> {
	public BirchOvenTileRenderer() {
		super(new BirchOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(BirchOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
