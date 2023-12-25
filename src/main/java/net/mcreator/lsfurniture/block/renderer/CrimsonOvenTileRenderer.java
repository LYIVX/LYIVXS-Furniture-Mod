package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonOvenBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonOvenTileEntity;

public class CrimsonOvenTileRenderer extends GeoBlockRenderer<CrimsonOvenTileEntity> {
	public CrimsonOvenTileRenderer() {
		super(new CrimsonOvenBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonOvenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
