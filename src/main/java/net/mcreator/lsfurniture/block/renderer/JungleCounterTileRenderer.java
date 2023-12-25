package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleCounterTileEntity;

public class JungleCounterTileRenderer extends GeoBlockRenderer<JungleCounterTileEntity> {
	public JungleCounterTileRenderer() {
		super(new JungleCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
