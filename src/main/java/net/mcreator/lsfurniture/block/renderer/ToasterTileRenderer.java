package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.ToasterBlockModel;
import net.mcreator.lsfurniture.block.entity.ToasterTileEntity;

public class ToasterTileRenderer extends GeoBlockRenderer<ToasterTileEntity> {
	public ToasterTileRenderer() {
		super(new ToasterBlockModel());
	}

	@Override
	public RenderType getRenderType(ToasterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
