package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaDeskBlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaDeskTileEntity;

public class AcaciaDeskTileRenderer extends GeoBlockRenderer<AcaciaDeskTileEntity> {
	public AcaciaDeskTileRenderer() {
		super(new AcaciaDeskBlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaDeskTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
