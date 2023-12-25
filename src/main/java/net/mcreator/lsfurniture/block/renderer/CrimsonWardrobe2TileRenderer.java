package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonWardrobe2BlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonWardrobe2TileEntity;

public class CrimsonWardrobe2TileRenderer extends GeoBlockRenderer<CrimsonWardrobe2TileEntity> {
	public CrimsonWardrobe2TileRenderer() {
		super(new CrimsonWardrobe2BlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonWardrobe2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
