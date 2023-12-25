package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaCupboardBlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaCupboardTileEntity;

public class AcaciaCupboardTileRenderer extends GeoBlockRenderer<AcaciaCupboardTileEntity> {
	public AcaciaCupboardTileRenderer() {
		super(new AcaciaCupboardBlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaCupboardTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
