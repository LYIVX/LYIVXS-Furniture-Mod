package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaDioriteCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaDioriteCounterTileEntity;

public class AcaciaDioriteCounterTileRenderer extends GeoBlockRenderer<AcaciaDioriteCounterTileEntity> {
	public AcaciaDioriteCounterTileRenderer() {
		super(new AcaciaDioriteCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaDioriteCounterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
