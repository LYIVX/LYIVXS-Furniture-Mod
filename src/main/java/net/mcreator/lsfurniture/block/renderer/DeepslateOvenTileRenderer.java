package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DeepslateOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.DeepslateOvenTileEntity;

public class DeepslateOvenTileRenderer extends GeoBlockRenderer<DeepslateOvenTileEntity> {
	public DeepslateOvenTileRenderer() {
		super(new DeepslateOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(DeepslateOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
