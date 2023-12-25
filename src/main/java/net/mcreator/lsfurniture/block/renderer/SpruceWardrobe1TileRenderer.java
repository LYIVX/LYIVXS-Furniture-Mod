package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceWardrobe1BlockModel;
import net.mcreator.lsfurniture.block.entity.SpruceWardrobe1TileEntity;

public class SpruceWardrobe1TileRenderer extends GeoBlockRenderer<SpruceWardrobe1TileEntity> {
	public SpruceWardrobe1TileRenderer() {
		super(new SpruceWardrobe1BlockModel());
	}

	@Override
	public RenderType getRenderType(SpruceWardrobe1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
