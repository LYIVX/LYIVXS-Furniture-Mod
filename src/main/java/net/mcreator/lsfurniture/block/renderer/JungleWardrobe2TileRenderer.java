package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleWardrobe2BlockModel;
import net.mcreator.lsfurniture.block.entity.JungleWardrobe2TileEntity;

public class JungleWardrobe2TileRenderer extends GeoBlockRenderer<JungleWardrobe2TileEntity> {
	public JungleWardrobe2TileRenderer() {
		super(new JungleWardrobe2BlockModel());
	}

	@Override
	public RenderType getRenderType(JungleWardrobe2TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
