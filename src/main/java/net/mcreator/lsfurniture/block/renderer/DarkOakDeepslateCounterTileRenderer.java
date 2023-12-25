package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakDeepslateCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.DarkOakDeepslateCounterTileEntity;

public class DarkOakDeepslateCounterTileRenderer extends GeoBlockRenderer<DarkOakDeepslateCounterTileEntity> {
	public DarkOakDeepslateCounterTileRenderer() {
		super(new DarkOakDeepslateCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(DarkOakDeepslateCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
