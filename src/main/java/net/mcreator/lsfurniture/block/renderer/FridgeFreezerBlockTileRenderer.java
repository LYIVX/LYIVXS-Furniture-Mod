package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.FridgeFreezerBlockBlockModel;
import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlockTileEntity;

public class FridgeFreezerBlockTileRenderer extends GeoBlockRenderer<FridgeFreezerBlockTileEntity> {
	public FridgeFreezerBlockTileRenderer() {
		super(new FridgeFreezerBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(FridgeFreezerBlockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
