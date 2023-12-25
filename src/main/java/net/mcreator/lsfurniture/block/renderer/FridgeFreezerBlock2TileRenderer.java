package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.FridgeFreezerBlock2BlockModel;
import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlock2TileEntity;

public class FridgeFreezerBlock2TileRenderer extends GeoBlockRenderer<FridgeFreezerBlock2TileEntity> {
	public FridgeFreezerBlock2TileRenderer() {
		super(new FridgeFreezerBlock2BlockModel());
	}

	@Override
	public RenderType getRenderType(FridgeFreezerBlock2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
