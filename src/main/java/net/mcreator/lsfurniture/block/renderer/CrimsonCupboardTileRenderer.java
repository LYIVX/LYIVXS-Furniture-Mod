package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonCupboardBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonCupboardTileEntity;

public class CrimsonCupboardTileRenderer extends GeoBlockRenderer<CrimsonCupboardTileEntity> {
	public CrimsonCupboardTileRenderer() {
		super(new CrimsonCupboardBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonCupboardTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
