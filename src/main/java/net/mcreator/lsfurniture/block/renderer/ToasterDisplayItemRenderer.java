package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.ToasterDisplayModel;
import net.mcreator.lsfurniture.block.display.ToasterDisplayItem;

public class ToasterDisplayItemRenderer extends GeoItemRenderer<ToasterDisplayItem> {
	public ToasterDisplayItemRenderer() {
		super(new ToasterDisplayModel());
	}

	@Override
	public RenderType getRenderType(ToasterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
