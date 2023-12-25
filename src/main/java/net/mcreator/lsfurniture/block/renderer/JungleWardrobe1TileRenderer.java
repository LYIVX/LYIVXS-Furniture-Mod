package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleWardrobe1BlockModel;
import net.mcreator.lsfurniture.block.entity.JungleWardrobe1TileEntity;

public class JungleWardrobe1TileRenderer extends GeoBlockRenderer<JungleWardrobe1TileEntity> {
	public JungleWardrobe1TileRenderer() {
		super(new JungleWardrobe1BlockModel());
	}

	@Override
	public RenderType getRenderType(JungleWardrobe1TileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
