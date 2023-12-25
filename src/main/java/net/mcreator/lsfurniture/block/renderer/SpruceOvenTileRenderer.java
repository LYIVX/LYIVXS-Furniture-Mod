package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.SpruceOvenTileEntity;

public class SpruceOvenTileRenderer extends GeoBlockRenderer<SpruceOvenTileEntity> {
	public SpruceOvenTileRenderer() {
		super(new SpruceOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(SpruceOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
