package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleDrawerBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleDrawerTileEntity;

public class JungleDrawerTileRenderer extends GeoBlockRenderer<JungleDrawerTileEntity> {
	public JungleDrawerTileRenderer() {
		super(new JungleDrawerBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleDrawerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
