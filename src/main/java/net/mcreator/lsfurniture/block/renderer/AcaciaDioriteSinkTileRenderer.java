package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaDioriteSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaDioriteSinkTileEntity;

public class AcaciaDioriteSinkTileRenderer extends GeoBlockRenderer<AcaciaDioriteSinkTileEntity> {
	public AcaciaDioriteSinkTileRenderer() {
		super(new AcaciaDioriteSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaDioriteSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
