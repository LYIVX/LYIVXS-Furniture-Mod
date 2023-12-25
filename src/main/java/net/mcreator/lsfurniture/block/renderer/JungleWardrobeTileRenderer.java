package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleWardrobeBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleWardrobeTileEntity;

public class JungleWardrobeTileRenderer extends GeoBlockRenderer<JungleWardrobeTileEntity> {
	public JungleWardrobeTileRenderer() {
		super(new JungleWardrobeBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleWardrobeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
