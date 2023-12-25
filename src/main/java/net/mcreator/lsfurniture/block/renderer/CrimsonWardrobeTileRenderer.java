package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonWardrobeBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonWardrobeTileEntity;

public class CrimsonWardrobeTileRenderer extends GeoBlockRenderer<CrimsonWardrobeTileEntity> {
	public CrimsonWardrobeTileRenderer() {
		super(new CrimsonWardrobeBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonWardrobeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
