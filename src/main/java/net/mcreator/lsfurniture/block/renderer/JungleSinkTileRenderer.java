package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleSinkTileEntity;

public class JungleSinkTileRenderer extends GeoBlockRenderer<JungleSinkTileEntity> {
	public JungleSinkTileRenderer() {
		super(new JungleSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
