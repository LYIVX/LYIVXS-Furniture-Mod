package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleCupboardBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleCupboardTileEntity;

public class JungleCupboardTileRenderer extends GeoBlockRenderer<JungleCupboardTileEntity> {
	public JungleCupboardTileRenderer() {
		super(new JungleCupboardBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleCupboardTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
