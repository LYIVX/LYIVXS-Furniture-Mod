package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.FridgeFreezerBlock1BlockModel;
import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlock1TileEntity;

public class FridgeFreezerBlock1TileRenderer extends GeoBlockRenderer<FridgeFreezerBlock1TileEntity> {
	public FridgeFreezerBlock1TileRenderer() {
		super(new FridgeFreezerBlock1BlockModel());
	}

	@Override
	public RenderType getRenderType(FridgeFreezerBlock1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
