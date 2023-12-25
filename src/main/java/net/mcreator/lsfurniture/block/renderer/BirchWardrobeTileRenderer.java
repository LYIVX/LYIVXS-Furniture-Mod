package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.BirchWardrobeBlockModel;
import net.mcreator.lsfurniture.block.entity.BirchWardrobeTileEntity;

public class BirchWardrobeTileRenderer extends GeoBlockRenderer<BirchWardrobeTileEntity> {
	public BirchWardrobeTileRenderer() {
		super(new BirchWardrobeBlockModel());
	}

	@Override
	public RenderType getRenderType(BirchWardrobeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
