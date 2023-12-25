package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceAndesiteCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.SpruceAndesiteCounterTileEntity;

public class SpruceAndesiteCounterTileRenderer extends GeoBlockRenderer<SpruceAndesiteCounterTileEntity> {
	public SpruceAndesiteCounterTileRenderer() {
		super(new SpruceAndesiteCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(SpruceAndesiteCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
