package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.OakCupboardBlockModel;
import net.mcreator.lsfurniture.block.entity.OakCupboardTileEntity;

public class OakCupboardTileRenderer extends GeoBlockRenderer<OakCupboardTileEntity> {
	public OakCupboardTileRenderer() {
		super(new OakCupboardBlockModel());
	}

	@Override
	public RenderType getRenderType(OakCupboardTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
