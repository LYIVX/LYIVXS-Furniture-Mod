package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceDrawerBlockModel;
import net.mcreator.lsfurniture.block.entity.SpruceDrawerTileEntity;

public class SpruceDrawerTileRenderer extends GeoBlockRenderer<SpruceDrawerTileEntity> {
	public SpruceDrawerTileRenderer() {
		super(new SpruceDrawerBlockModel());
	}

	@Override
	public RenderType getRenderType(SpruceDrawerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
