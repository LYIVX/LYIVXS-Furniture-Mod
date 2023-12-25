package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceCupboardBlockModel;
import net.mcreator.lsfurniture.block.entity.SpruceCupboardTileEntity;

public class SpruceCupboardTileRenderer extends GeoBlockRenderer<SpruceCupboardTileEntity> {
	public SpruceCupboardTileRenderer() {
		super(new SpruceCupboardBlockModel());
	}

	@Override
	public RenderType getRenderType(SpruceCupboardTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
