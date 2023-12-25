package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleNetherBricksSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleNetherBricksSinkTileEntity;

public class JungleNetherBricksSinkTileRenderer extends GeoBlockRenderer<JungleNetherBricksSinkTileEntity> {
	public JungleNetherBricksSinkTileRenderer() {
		super(new JungleNetherBricksSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleNetherBricksSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
