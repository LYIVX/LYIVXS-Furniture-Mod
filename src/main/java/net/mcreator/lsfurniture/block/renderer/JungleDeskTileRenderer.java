package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleDeskBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleDeskTileEntity;

public class JungleDeskTileRenderer extends GeoBlockRenderer<JungleDeskTileEntity> {
	public JungleDeskTileRenderer() {
		super(new JungleDeskBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleDeskTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
