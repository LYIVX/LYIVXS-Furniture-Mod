package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleNetherBricksCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleNetherBricksCounterTileEntity;

public class JungleNetherBricksCounterTileRenderer extends GeoBlockRenderer<JungleNetherBricksCounterTileEntity> {
	public JungleNetherBricksCounterTileRenderer() {
		super(new JungleNetherBricksCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleNetherBricksCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
