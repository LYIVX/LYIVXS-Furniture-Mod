package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaSinkBlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaSinkTileEntity;

public class AcaciaSinkTileRenderer extends GeoBlockRenderer<AcaciaSinkTileEntity> {
	public AcaciaSinkTileRenderer() {
		super(new AcaciaSinkBlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaSinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
