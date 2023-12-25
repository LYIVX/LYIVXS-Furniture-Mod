package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaWardrobe1BlockModel;
import net.mcreator.lsfurniture.block.entity.AcaciaWardrobe1TileEntity;

public class AcaciaWardrobe1TileRenderer extends GeoBlockRenderer<AcaciaWardrobe1TileEntity> {
	public AcaciaWardrobe1TileRenderer() {
		super(new AcaciaWardrobe1BlockModel());
	}

	@Override
	public RenderType getRenderType(AcaciaWardrobe1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
