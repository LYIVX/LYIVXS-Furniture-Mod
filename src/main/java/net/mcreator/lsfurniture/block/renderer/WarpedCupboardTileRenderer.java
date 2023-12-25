package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedCupboardBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedCupboardTileEntity;

public class WarpedCupboardTileRenderer extends GeoBlockRenderer<WarpedCupboardTileEntity> {
	public WarpedCupboardTileRenderer() {
		super(new WarpedCupboardBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedCupboardTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
