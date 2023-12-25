package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveCupboardBlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveCupboardTileEntity;

public class MangroveCupboardTileRenderer extends GeoBlockRenderer<MangroveCupboardTileEntity> {
	public MangroveCupboardTileRenderer() {
		super(new MangroveCupboardBlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveCupboardTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
