package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleOvenTileEntity;

public class JungleOvenTileRenderer extends GeoBlockRenderer<JungleOvenTileEntity> {
	public JungleOvenTileRenderer() {
		super(new JungleOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
