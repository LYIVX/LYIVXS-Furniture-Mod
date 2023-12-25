package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakDeepslateSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.DarkOakDeepslateSinkTileEntity;

public class DarkOakDeepslateSinkTileRenderer extends GeoBlockRenderer<DarkOakDeepslateSinkTileEntity> {
	public DarkOakDeepslateSinkTileRenderer() {
		super(new DarkOakDeepslateSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(DarkOakDeepslateSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
