package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchGraniteSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.BirchGraniteSinkTileEntity;

public class BirchGraniteSinkTileRenderer extends GeoBlockRenderer<BirchGraniteSinkTileEntity> {
	public BirchGraniteSinkTileRenderer() {
		super(new BirchGraniteSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(BirchGraniteSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
