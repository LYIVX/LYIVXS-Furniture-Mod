package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceAndesiteSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.SpruceAndesiteSinkTileEntity;

public class SpruceAndesiteSinkTileRenderer extends GeoBlockRenderer<SpruceAndesiteSinkTileEntity> {
	public SpruceAndesiteSinkTileRenderer() {
		super(new SpruceAndesiteSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(SpruceAndesiteSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
