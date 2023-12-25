package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonWardrobe1BlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonWardrobe1TileEntity;

public class CrimsonWardrobe1TileRenderer extends GeoBlockRenderer<CrimsonWardrobe1TileEntity> {
	public CrimsonWardrobe1TileRenderer() {
		super(new CrimsonWardrobe1BlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonWardrobe1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
