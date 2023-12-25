package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.MangroveWardrobe1BlockModel;
import net.mcreator.lsfurniture.block.entity.MangroveWardrobe1TileEntity;

public class MangroveWardrobe1TileRenderer extends GeoBlockRenderer<MangroveWardrobe1TileEntity> {
	public MangroveWardrobe1TileRenderer() {
		super(new MangroveWardrobe1BlockModel());
	}

	@Override
	public RenderType getRenderType(MangroveWardrobe1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
